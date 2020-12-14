'use strict';

import React from 'react';
import {
	StyleSheet,
	Text,
	View,
	Image,
	ScrollView,
	RefreshControl,
	TouchableOpacity,
	InteractionManager
} from 'react-native';
import {commonPageCheckAndInit} from '<#list 1..spritNum as i>../</#list>util/PageUtil';
import {COLOR_MAIN_COLOR, COLOR_BLACK, COLOR_WHITE, COLOR_REFRESH_CONTROL} from '<#list 1..spritNum+1 as i>../</#list>constant/StaticDataDef';

export default class ${(firstUpperPage)!} extends React.Component {

	constructor(props){
		super(props);
		this.state = {

		};
	}

	componentDidMount() {
		const {<#list datas as data>${(data.firstLowerAction)!}<#if data_has_next>, </#if></#list>} = this.props;
		InteractionManager.runAfterInteractions(() => {
			${(firstLowerAction)!'Action'}(false, true);
		})
	}

	onRefresh() {
		const {<#list datas as data>${(data.firstLowerAction)!}<#if data_has_next>, </#if></#list>} = this.props;
		${(firstLowerAction)!'Action'}(true, false);
	}

	render() {
		const {<#list datas as data>${(data.firstLowerCode)!}<#if data_has_next>, </#if></#list>} = this.props;
		let view = commonPageCheckAndInit(${(firstLowerCode)!'{}'}, ()=>{return this.renderView()});
		return (
			<ScrollView style={{backgroundColor: '#FFF'}}
			            contentContainerStyle={styles.contentContainer}
			            refreshControl={
				            <RefreshControl
				              refreshing={${(firstLowerCode)!'{}'}.isRefreshing}
				              onRefresh={this.onRefresh.bind(this)}
				              title="加载中..."
				              colors={COLOR_REFRESH_CONTROL}
				            />}>
				{view}
			</ScrollView>);
	}
}

const styles = StyleSheet.create({
	contentContainer: {
		paddingVertical: 20
	}
});