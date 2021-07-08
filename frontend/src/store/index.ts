import {applyMiddleware, createStore} from 'redux';
import {composeWithDevTools} from 'redux-devtools-extension';
import createSagaMiddleware from 'redux-saga';
import {combineReducers} from 'redux-starter-kit';
import sagas from './sagas';
import reducers from './reducers';
import { createLogger } from 'redux-logger';

const reducer = combineReducers(reducers);
export type IState = ReturnType<typeof reducer>;

export default () => {
  const composeEnhancers = composeWithDevTools({});
  const loggerMiddleware = createLogger({ collapsed: true, duration: true });
  const sagaMiddleware = createSagaMiddleware();
  const middleware = [loggerMiddleware, sagaMiddleware]
  const middlewares = applyMiddleware(...middleware);
  const store = createStore(reducer, composeEnhancers(middlewares));
  (window as any).store = store;
  sagaMiddleware.run(sagas);

  return store;
};