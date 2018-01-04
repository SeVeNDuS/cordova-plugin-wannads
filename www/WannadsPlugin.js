/*
 * File Name  : WannadsPlugin.js
 * Author     : Wannads
 * Description : This file initiates calls to the native library from the plugin
 */


function cordovaExecCommand(command) {
    var args = Array.prototype.slice.call(arguments, 1);
    cordova.exec(function callback(data) {
        },
        function errorHandler(err) {
        },
        'WannadsPlugin',
        command,
        args
    );
}


function cordovaExecCommandCallback(command, callback) {
    var args = Array.prototype.slice.call(arguments, 2);
    cordova.exec(callback,
        function errorHandler(err) {
        },
        'WannadsPlugin',
        command,
        args
    );
}


var WannadsPlugin = {

    // General
    VERSION_STRING: "1.0.0",


    // Init Parameter MapObject Key Strings
    PARAM_API_KEY: "apikey",
    PARAM_SUB_ID: "subid",

    // Optional parameters
    PARAM_SUB_ID_2: "subid2",
    PARAM_GENDER: "gender",
    PARAM_AGE: "age",



    configure: function (parametersMapObject) {
        parametersMapObject["versionExtension"] = " (Cordova " + WannadsPlugin.VERSION_STRING + ")";

        cordovaExecCommand('configure', parametersMapObject);
    },

    showOffers: function (categoryName) {
        cordovaExecCommand('showOffers', categoryName);
    }


};


module.exports = WannadsPlugin;



