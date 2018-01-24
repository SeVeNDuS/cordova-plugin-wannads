#import <Cordova/CDV.h>
#import <wannadsiossdk/WannadsSDK.h>


@interface WannadsPlugin : CDVPlugin


@property NSString *email;
@property NSString *apikey;


@property NSString *appId;
@property NSString *subId;
@property NSString *gender;
@property NSString *age;
	
- (void) configure: (CDVInvokedUrlCommand*)command;
- (void) showOffers:(CDVInvokedUrlCommand*)command;  

@end