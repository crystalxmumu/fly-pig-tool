'use strict';

import {
  CLEAR,
  FULFILLED,
  PENDING,
  REJECTED,
  <#list datas as data>
  ${(data.dic.code)!},
  </#list>
} from '<#list 1..spritNum+1 as i>../</#list>constant/ActionType';
import {initialCommonState} from '<#list 1..spritNum as i>../</#list>default';

<#--<#list datas as data>
const initial${(data.firstUpperCode)!}State = {
  isRefreshing: false,
  loading: false,
  isLoadMore: false,
}
</#list>-->

<#list datas as data>
/**
 * ${(data.dic.cnName)!}
 * @param state 上次状态
 * @param action 操作结果
 * @returns {{isLoadMore: boolean, loading: boolean, isRefreshing: boolean}}
 */
export function ${(data.firstLowerCode)!}(
  state = initialCommonState,
  action,
) {
  //console.log('${(data.dic.cnName)!}数据',action);
  const {type, payload} = action;
  switch (type) {
    case `${r'$'}{${(data.dic.code)!}.code}_${r'$'}{CLEAR}`:
      return initialCommonState;
    case `${r'$'}{${(data.dic.code)!}.code}_${r'$'}{PENDING}`:
      return {
        ...state,
        ...payload,
      };
    case `${r'$'}{${(data.dic.code)!}.code}_${r'$'}{FULFILLED}`:
    case `${r'$'}{${(data.dic.code)!}.code}_${r'$'}{REJECTED}`:
      return {
        ...state,
        ...payload,
        ...initialCommonState,
      };
    default:
      return state;
  }
}

</#list>