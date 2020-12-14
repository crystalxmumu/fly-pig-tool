'use strict';

import React from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import ${(firstUpperPage)!} from '<#list 1..spritNum+1 as i>../</#list>page${path!}/${(firstUpperPage)!}';

<#if datas?? && (datas?size > 0)>
import {<#list datas as data>${(data.firstLowerAction)!}<#if data_has_next>, </#if></#list>} from '<#list 1..spritNum+1 as i>../</#list>action${path!}/${(actionFileName)!}';
</#if>

class ${(firstUpperContainer)!} extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return <${(firstUpperPage)!} {...this.props} />;
  }

  static navigationOptions = ({navigation}) => ({
    headerTitle: '${pageNameDesc!}',
  });
}

const mapStateToProps = (state) => {
  const {<#list datas as data>${(data.firstLowerCode)!}<#if data_has_next>, </#if></#list>} = state;
  return {
    <#list datas as data>
    ${(data.firstLowerCode)!}<#if data_has_next>,</#if>
    </#list>
  };
};

const mapDispatchToProps = (dispatch) => {
  return bindActionCreators({<#list datas as data>${(data.firstLowerAction)!}<#if data_has_next>, </#if></#list>}, dispatch);
};

export default connect(
  mapStateToProps,
  mapDispatchToProps,
)(${(firstUpperContainer)!});