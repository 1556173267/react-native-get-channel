'use strict';

import {NativeModules, Platform } from 'react-native';
const GetChannelModule = NativeModules.GetChannelModule;

export function getAppMetaData(key) {
  if (Platform.OS === 'android') {
    return new Promise((resolve, reject) => {
      GetChannelModule.getAppMetaData(key).then((data)=>{
      	resolve(data);
      }).catch((error)=>{
      	reject(error);
      });
    });
  } else {
    return new Promise((resolve, reject) => {
      resolve(null);
    });
  }
}
