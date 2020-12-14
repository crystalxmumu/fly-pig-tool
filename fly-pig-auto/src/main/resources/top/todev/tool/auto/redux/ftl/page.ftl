'use strict';

import React from 'react';
import {View, StyleSheet, Text, Button} from 'react-native';

export default class ${(firstUpperPage)!} extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  componentDidMount() {}

  render() {
    return (
      <View style={styles.container}>
        <Button onPress={this._onPress} title="跳转" color="#841584" />
      </View>
    );
  }

  _onPress = () => {
    const {navigation} = this.props;
    navigation.navigate('Test');
  };
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});