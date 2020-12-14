'use strict';

import {
  CLEAR,
  PENDING,
  <#list datas as data>
  ${(data.dic.code)!},
  </#list>
} from '<#list 1..spritNum+1 as i>../</#list>constant/ActionType';

<#list datas as data>
/**
 * ${(data.dic.cnName)!}
 * @param isRefreshing 是否重加载
 * @param loading 是否正在加载
 * @param isLoadMore 是否加载更多
 * @param data
 * @returns {*}
 */
export function ${(data.firstLowerAction)!}(
  isRefreshing = false,
  loading = false,
  isLoadMore = false,
  data,
) {
  return isRefreshing || loading || isLoadMore
    ? {
        type: `${r'$'}{${(data.dic.code)!}.code}_${r'$'}{PENDING}`,
        payload: {isRefreshing, loading, isLoadMore, data},
      }
    : {type: `${r'$'}{${(data.dic.code)!}.code}_${r'$'}{CLEAR}`};
}

</#list>