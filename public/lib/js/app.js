'use strict';
angular.module('adschela',
		['ngResource','ngRoute','ngDialog','ui.bootstrap','ui.bootstrap.tpls','rcWizard', 'rcForm', 'rcDisabledBootstrap'])
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
                        	      .when('/make-booking.html', {
                        	        templateUrl: 'make-booking.html',
                        	        controller: 'MakeBookingController'
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
								            	google.language.transliterate([$(event.target).val()], "en", "hi", function(result) {
								          		  if (!result.error) {
								          		    if (result.transliterations && result.transliterations.length > 0 ) {
								          		    	console.log(result.transliterations[0].transliteratedWords[0]);
								          		    	scope.onTranslationDone({data:result.transliterations[0].transliteratedWords[0]});
								          		    }
								          		  }
								          		});
								            	
								            }
								        });
									}
						    		
						    	}
						        
						    }]);
