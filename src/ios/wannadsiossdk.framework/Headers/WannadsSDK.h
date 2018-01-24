//
//  InsertManager.h
//  wannadsiossdk
//
//  Copyright © 2017 Innovative Hall Media Technologies. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

typedef enum {MALE, FEMALE} WANGender;
#define WANGenderString(enum) [@[@"male",@"female"] objectAtIndex:enum]


@interface WannadsSDK : NSObject

+ (instancetype) sharedInstance;

- (void)initWithApiKey: (NSString *)apiKey andSubId: (NSString *)subId;

- (void)showOffersFromController: (UIViewController *)controller;

- (void)showOffersWithCategory: (NSString *)category fromController: (UIViewController *)controller;

- (NSString *)getApiKey;

- (NSString *)getSubId;

- (NSString *)getSubId2;

- (NSString *)getDeviceLocale;

- (NSString *)getAdvertisingId;

- (int)getAge;

- (WANGender)getGender;

- (void)setSubId2: (NSString *)subId2;

- (void)setAge: (int)age;

- (void)setGender: (WANGender)gender;


@end
