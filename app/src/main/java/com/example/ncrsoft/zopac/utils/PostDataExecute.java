package com.example.ncrsoft.zopac.utils;

/**
 * Created by NcrSoft on 01-Mar-17.
 */

public interface PostDataExecute {

    void onPostRequestSuccess(int method, String resp);

    void onPostRequestFailed(int method, String resp);
}
