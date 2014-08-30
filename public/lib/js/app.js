'use strict';
angular.module('adschela',[
                           'ngResource','ngRoute'
                         ]).config(function ($routeProvider) {
                        	    $routeProvider
                        	      .when('/', {
                        	        templateUrl: 'home.html',
                        	        controller: 'IndexController'
                        	      })
                        	      .when('/textClassifiedController', {
                        	        templateUrl: 'textClassifiedController.html',
                        	        controller: 'TextClassifiedController'
                        	      })
                        	});