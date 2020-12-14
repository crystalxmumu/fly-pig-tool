<#list datas as data>
export const ${(data.dic.code)!} = new ActionType(
  '${(data.dic.code)!}',
  '${(data.dic.cnName)!}',
  '${(data.dic.value)!}',
  '/app/index',
);

</#list>