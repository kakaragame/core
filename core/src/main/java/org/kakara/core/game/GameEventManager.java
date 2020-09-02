package org.kakara.core.game;

import me.kingtux.simpleannotation.MethodFinder;
import org.kakara.core.GameInstance;
import org.kakara.core.Kakara;
import org.kakara.core.events.*;
import org.kakara.core.events.annotations.EventHandler;
import org.kakara.core.events.player.Listener;
import org.kakara.core.mod.Mod;

import java.lang.reflect.Method;

public class GameEventManager implements EventManager {
    private GameInstance GameInstance;

    @Override
    public void registerEventHandler(Listener handler, Mod mod) {
        Method[] methods = MethodFinder.getAllMethodsWithAnnotation(handler.getClass(), EventHandler.class, false);
        for (Method method : methods) {
            if (method.getParameterTypes().length == 1) {
                @SuppressWarnings("unchecked")
                HandlerList handlerList = EventUtils.getHandlerList((Class<? extends Event>) method.getParameterTypes()[0]);
                if (handlerList == null) {
                    Kakara.LOGGER.error(String.format("Unable to locate HandlerList for %s", method.getName()));
                    continue;
                }
                handlerList.addHandler(mod, handler, method);
            }
        }
    }

    @Override
    public void callEvent(Event event) {
        for (RegisteredListener registeredListener : event.getHandlerList().getListenerList()) {
            if (event instanceof Cancellable) {
                if (((Cancellable) event).isCancelled()) break;
            }
            EventExecutor eventExecutor = registeredListener.call();
            try {
                eventExecutor.execute(event);
            } catch (EventException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void load(GameInstance GameInstance) {
        this.GameInstance = GameInstance;
    }


    @Override
    public Class<?> getStageClass() {
        return EventManager.class;
    }
}
