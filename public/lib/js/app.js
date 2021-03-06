'use strict';
var app = angular.module('adschela',
		['ngResource','ngRoute','ngDialog','ui.bootstrap','ui.bootstrap.transition','ui.bootstrap.tpls',
		 'rcWizard', 'rcForm', 'rcDisabledBootstrap','ngCookies'])
                           .config(function ($routeProvider) {
                        	    $routeProvider
                        	      .when('/', {
                        	        templateUrl: 'home.html',
                        	        controller: 'IndexController'
                        	      })
                        	      .when('/textClassifiedController', {
                        	        templateUrl: 'textClassifiedController.html',
                        	        controller: 'TextClassifiedController'
                        	      })
                        	      .when('/compose-classified-Ad/:id', {
                        	        templateUrl: 'compose-classified-Ad',
                        	        controller: 'MakeBookingController'
                        	      })
                        	      .when('/aboutUs', {
                        	        templateUrl: 'AboutUs.html',
                        	        controller: 'AboutUsController'
                        	      })
                        	      .when('/myAccount', {
                        	        templateUrl: '/assets/MyAccount.html',
                        	        controller: 'MyAccountController'
                        	      })
                        	      .when('/contactUs', {
                        	        templateUrl: 'Contact.html',
                        	        controller: 'ContactUsController'
                        	      })
                        	        .when('/ourClient', {
                        	        templateUrl: 'OurClients.html',
                        	        controller: 'OurClientController'
                        	      })
                        	        .when('/ourServices', {
                        	        templateUrl: '/',
                        	        controller: 'OurServicesController'
                        	      })
                        	      .when('/ourBlogs', {
                        	        templateUrl: 'Blog.html',
                        	        controller: 'BlogController'
                        	      })
                        	      .when('/manageAnnouncement', {
                        	        templateUrl: 'manageAnnouncements.html',
                        	        controller: 'ShowAnnouncementController'
                        	      })
                          	      .when('/termsAndConditions', {
                        	        templateUrl: 'TermsandConditions.html',
                        	         controller: 'TermsandConditionsController'
                        	      })
                        	        .when('/privacyPolicy', {
                        	        templateUrl: 'PrivacyPolicy.html',
                        	       controller: 'PrivacyPolicyController'
                        	      })
                        	        .when('/paymentGateway', {
                        	        templateUrl: 'Paymentoption.html',
                        	        controller: 'PaymentoptionController'
                        	      })
                        	        .when('/deClaimer', {
                        	        templateUrl: 'Disclaimer.html',
                        	        controller: 'DisclaimerController'
                        	      })
                        	        .when('/help', {
                        	        templateUrl: 'Help.html',
                        	        controller: 'HelpController'
                        	      })
                        	        .when('/dispAds', {
                        	        templateUrl: 'addisplay.html',
                        	        controller: 'AddisplayController'
                        	      })
                        	        .when('/affilatedLogin', {
                        	        templateUrl: 'Affiliatedlogin.html',
                        	        controller: 'AffiliatedloginController'
                        	      })
                        	      .when('/readENewspaper', {
                          	        templateUrl: 'E-NewsPaper.html',
                          	        controller: 'ENewsPaperController'
                          	      })
                          	       .when('/dispClassified', {
                          	        templateUrl: 'dispFrame.html',
                          	        controller: 'dispclassifiedcontroller'
                          	      })
                        	}).directive('ngGoogleTransliterate',['$window','$parse', function ($window,$parse) {
						    	return {
						    		require: '^ngModel',
									scope: {
									      ngModel: '=',
									      onTranslationDone: '&',
									},
									link: function (scope, element, attr) {
										element.bind("keypress", function (event) {
								            if(event.which === 13 || event.which === 32 ) {
								            	var lastSep = ($(event.target).val()).split(" ");
								            	google.language.transliterate([lastSep[lastSep.length-1]], "en", "hi", function(result) {
								          		  if (!result.error) {
								          		    if (result.transliterations && result.transliterations.length > 0 ) {
								          		    	scope.onTranslationDone({data:result.transliterations[0].transliteratedWords[0]});
								          		    }
								          		  }
								          		});
								            	
								            }
								        });
									}
						    		
						    	}
						        
                        	}]).directive('pwCheck', [function () {
						    	return {
						    	    require: 'ngModel',
						    	    link: function (scope, elem, attrs, ctrl) {
						    	        var firstPassword = '#' + attrs.pwCheck;
						    	        elem.add(firstPassword).on('keyup', function () {
						    	            scope.$apply(function () {
						    	                // console.info(elem.val() === $(firstPassword).val());
						    	                ctrl.$setValidity('pwmatch', elem.val() === $(firstPassword).val());
						    	            });
						    	        });
						    	    }
						    	}
						    	}]);

app.factory('MyHttpInterceptor', function ($q) {
    return {
      request: function (config) {
                  $('#loading-id').show();
                  return config || $q.when(config);           
      },
 
      requestError: function (rejection) {
                  $('#loading-id').hide();
          return $q.reject(rejection);
      },
 
      // On response success
      response: function (response) {
                  $('#loading-id').hide();
          return response || $q.when(response);
      },
 
      // On response failture
      responseError: function (rejection) {
                  $('#loading-id').hide();
          return $q.reject(rejection);
      }
    };
});
app.config(function ($httpProvider) {
   $httpProvider.interceptors.push('MyHttpInterceptor');  
})
