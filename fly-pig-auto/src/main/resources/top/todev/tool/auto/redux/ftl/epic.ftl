import {of} from 'rxjs';
import {ofType} from 'redux-observable';
import {
  catchError,
  map,
  switchMap,
  throttleTime,
  withLatestFrom,
} from 'rxjs/operators';
import {toParam} from '../../util/ParamUtil';
import {fromFetchToken} from '../util/operators';
import {
  TIME_DEFAULT_INTERACTION,
  TIME_DEFAULT_NETWORK_MAX_TIMEOUT,
} from '../../constant/StaticDataDef';
import {
  commonResultFailureAction,
  commonResultSuccessAction,
  fetchResultSuccessAction,
} from '<#list 1..spritNum+1 as i>../</#list>action/common/common_result';
import {
  PENDING,
  <#list datas as data>
  ${(data.dic.code)!},
  </#list>
} from '<#list 1..spritNum+1 as i>../</#list>constant/ActionType';

<#list datas as data>
/**
 * ${(data.dic.cnName)!}处理方法
 * @param action$ action可观察对象
 * @param state$ state可观察对象
 * @returns {*} ${(data.dic.cnName)!}
 */
export const ${(data.firstLowerEpic)!} = (action$, state$) => {
  return action$.pipe(
    ofType(`${r'$'}{${(data.dic.code)!}.code}_${r'$'}{PENDING}`),
    throttleTime(TIME_DEFAULT_INTERACTION),
    withLatestFrom(state$, ({payload}, {${(data.firstLowerCode)!}}) => {
      // console.warn('${(data.dic.cnName)!}请求数据', ${(data.firstLowerCode)!});
      const {} = payload;
      const {data = {}} = ${(data.firstLowerCode)!};
      const {} = data;
      return toParam({});
    }),
    switchMap(params =>
      fromFetchToken(${(data.dic.code)!}.url + params).pipe(
        map(result => fetchResultSuccessAction(${(data.dic.code)!}, result)),
        catchError(err => of(commonResultFailureAction(${(data.dic.code)!}, err))),
      ),
    ),
  );
};

</#list>