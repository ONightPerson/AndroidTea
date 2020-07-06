package com.liubz.androidtea.network;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * author: created by liubaozhu on 2020/5/2
 * email: liubaozhu@baidu.com
 */
public class ContentHandler extends DefaultHandler {
    private static final String TAG = "ContentHandler";

    private String nodeName;
    private StringBuilder to;
    private StringBuilder from;

    @Override
    public void startDocument() throws SAXException {
        to = new StringBuilder();
        from = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        Log.i(TAG, "startElement: uri: " + uri + ", localName： " + localName + ", qName: " + qName
                + ", attributes: " + attributes);
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if ("to".equals(nodeName)) {
            to.append(ch, start, length);
        } else if ("from".equals(nodeName)) {
            from.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("note".equals(localName)) {
            Log.i(TAG, "endElement, element = " + this);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public String toString() {
        return "[to: " + to.toString() + ", from: " + from.toString() + "]";
    }
}
