#import "WannadsPlugin.h"
#import <objc/runtime.h>
#import <objc/message.h>

@implementation WannadsPlugin
    
- (void) pluginInitialize {
    [super pluginInitialize];
}
    
- (void) configure: (CDVInvokedUrlCommand*)command {
    NSDictionary *args = [command.arguments objectAtIndex: 0];
    NSString *apiKey = [args valueForKey: @"apikey"];
    NSString *subId = [args valueForKey: @"subid"];

   [self _configureWithApiKey: apiKey andSubId: subId];
}
    
    
- (void) showOffers: (CDVInvokedUrlCommand*)command {
    NSString *cagetory = [command.arguments objectAtIndex: 0];
    
    if ([cagetory isKindOfClass: [NSNull class]]) {
        cagetory = nil;
    }
    
    [self _showOffers: cagetory];
}
    
- (void) _configureWithApiKey:(NSString *)apiKey andSubId:(NSString *)subId {
    [[WannadsSDK sharedInstance] initWithApiKey: apiKey andSubId: subId];
}
    
-(void) _showOffers: (NSString *)category {
    UIViewController *controller = [UIApplication sharedApplication].keyWindow.rootViewController;
    
    if (category != nil && category.length > 0) {
        [[WannadsSDK sharedInstance] showOffersWithCategory: category fromController: self.viewController];
    } else {
        [[WannadsSDK sharedInstance] showOffersFromController: controller];
    }
}
    
@end
