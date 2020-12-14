<#if dics?? && dics?has_content >
	<#list dics as dic>
INSERT INTO bm_data_dictionary_def(ddd_id, ddd_code, ddd_name, ddd_desc, ddd_is_system, ddd_is_delete, ddd_sort, ddd_remark) VALUES ('${(dic.uid)!}','${(dic.code)!}','${(dic.name)!}','${(dic.desc)!}','${(dic.sys)!}',${(dic.del)!},${(dic.order)!?c},'${(dic.remark)!}');
		<#if dic.datas?? && (dic.datas)?has_content>
			<#list dic.datas as data>
INSERT INTO bm_static_data_def(sdd_id, sdd_ddd_id, sdd_code, sdd_name, sdd_value, sdd_rel_ddd, sdd_rel_sdd, sdd_ext_1, sdd_ext_2, sdd_ext_3, sdd_is_delete, sdd_desc, sdd_sort, sdd_remark) VALUES ('${(data.uid)!}','${(data.parent.uid)!}','${(data.code)!}','${(data.name)!}','${(data.value)!}', NULL, NULL, '${(data.ext1)!}', '${(data.ext3)!}', '${(data.ext3)!}', ${(data.del)!}, '${(data.desc)!}',${(data.order)!?c},'${(data.remark)!}');
			<#if data_index != 0 && data_index%200==0>
commit;
			</#if>
			</#list>
		</#if>
commit;

	</#list>
</#if>

<#if dics?? && dics?has_content >
	<#list dics as dic>
${(dic.code)!}("${(dic.code)!}","${(dic.name)!}","")<#if (dic.datas?? && (dic.datas)?has_content) || dic_has_next>,<#else>;</#if>
		<#if dic.datas?? && (dic.datas)?has_content>
			<#list dic.datas as data>
${(data.code)!}("${(data.code)!}","${(data.name)!}","${(data.value)!}")<#if dic_has_next || data_has_next>,<#else>;</#if>
			</#list>
		</#if>

	</#list>
</#if>