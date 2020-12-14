'use strict';

import {combineEpics} from 'redux-observable';
import {<#list datas as data>${(data.firstLowerEpic)!}<#if data_has_next>, </#if></#list>} from '.${path!}/${epicFileName!}';

export default combineEpics(
  <#list datas as data>
  ${(data.firstLowerEpic)!},
  </#list>
);
