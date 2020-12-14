'use strict';

import {combineReducers} from 'redux';
import {<#list datas as data>${(data.firstLowerCode)!}<#if data_has_next>, </#if></#list>} from '.${path!}/${reducerFileName!}';

const rootReducer = combineReducers({
  <#list datas as data>
  ${(data.firstLowerCode)!},
  </#list>
})

export default rootReducer;