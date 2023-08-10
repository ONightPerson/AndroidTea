//
// Created by liubaozhu on 8/10/23.
//
#include "com_liubz_androidtea_utils_NdkUtils.h"

JNIEXPORT jstring JNICALL Java_com_liubz_androidtea_utils_NdkUtils_getStringFromNdk
  (JNIEnv *env, jclass jclazz) {
    return (*env)->NewStringUTF(env, "Hello World，这是AndroidTea的第一行JNI代码");
  }


