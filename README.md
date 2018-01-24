## For installation instructions, see https://wannads.readme.io/docs/android-sdk

#Add the SDK into your project.

1. Download the Wannads SDK and unzip.
2. Create a Cordova project using the Cordova command line tool.
3. Add the Android platforms to your project.
4. Navigate to the top folder of your project with a command prompt or terminal, and enter the following (where sdk_path is the location where you unzipped the Wannads Cordova plugin):

```
cordova plugin add sdk_path\cordova_sdk
```


#Sample Code:

```
   // wannads configuration params       
   var wannadsParametersMapObject = {};
   
   wannadsParametersMapObject[WannadsPlugin.PARAM_API_KEY] = "_YOUR_WANNADS_API_KEY_HERE_";
   
   wannadsParametersMapObject[WannadsPlugin.PARAM_SUB_ID] = "_UUID";
 
   // wannads instance
   WannadsPlugin.configure(wannadsParametersMapObject);
   
   // launch offers panel
   WannadsPlugin.showOffers("_CATEGORY");
   
   
   // Android Quirk - show action bar
   WannadsPlugin.showOffers("_CATEGORY", true);

```