package com.liubz.androidtea.binderpool;

interface ISecurityCenter {
    String encrypt(String content);
    String decrypt(String password);
}
