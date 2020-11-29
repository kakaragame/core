package org.kakara.core.common.events.game;

import me.kingtux.simpleannotation.MethodFinder;
import org.kakara.core.common.GameInstance;
import org.kakara.core.common.GameObject;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.events.*;
import org.kakara.core.common.events.annotations.EventHandler;
import org.kakara.core.common.game.Item;
import org.kakara.core.common.mod.Mod;


import java.lang.reflect.Method;

public class GameEventManager implements EventManager {
    private GameInstance GameInstance;

    @Override
    public void registerEventHandler(Listener handler, Mod mod) {
        if(handler instanceof GameObject){
            throw new IllegalArgumentException("GameObject listeners may not be registered this way. ");
        }
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
