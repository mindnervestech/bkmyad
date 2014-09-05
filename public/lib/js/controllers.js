angular.module('adschela').controller("Booknewspaperaddonline",['$scope','beData',function($scope,beData){
	$scope.forTest = beData;
}]);

angular.module('adschela').controller("HeaderController",['$scope',function($scope){
}]);

angular.module('adschela').controller("FooterController",['$scope',function($scope){
}]);

angular.module('adschela').controller("IndexController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("AboutUsController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("ContactUsController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("OurClientController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("OurServicesController",['$scope',function($scope){
	
}]);angular.module('adschela').controller("TermsandConditionsController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("PrivacyPolicyController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("PaymentoptionController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("DisclaimerController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("HelpController",['$scope',function($scope){
	
}]);

angular.module('adschela').controller("dispclassifiedcontroller",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("AddisplayController",['$scope',function($scope){
	    $scope.init = function(dispadData) {
	//	$scope.sideRequest = dispadData.;
		$scope.resultCategory=dispadData.categories;
		$scope.resultNewspaperCategory =dispadData.newspapers;
	    console.log(dispadData.newspapers);
	 //   console.log(dispadData.categories);
		}
}]);

angular.module('adschela').controller("AffiliatedloginController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("ENewsPaperController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("BlogController",['$scope',function($scope){
	
}]);



angular.module('adschela').controller("ComposeAdController",['$scope',function($scope){
	$scope.selectedCartItemOnPopUp = GetSelectedCartItemOnPopUp();
	
	$scope.onComposeAdStepChange = function() {
		$scope.rc.composeWizard.forward();
		
		if($scope.rc.composeWizard.currentIndex === 1) {
			InitDatepicker();
		}
		
		if($scope.rc.composeWizard.currentIndex == 2) {
			
		}
		
	}
	
	$scope.onComposeAdDone = function() {
		SaveToCart($scope.selectedCartItemOnPopUp);
	}
	
	$scope.transliterateDone = function(data) {
		if($scope.selectedCartItemOnPopUp.isHindi) {
			$('#transliterateTextarea').val(data);
		} else {
			$('#transliterateTextarea').val($scope.selectedCartItemOnPopUp.description);
		}
		computeRateByUnit();
	};
	
	function countWords(){
		s = $('#transliterateTextarea').val();
		s = s.replace(/(^\s*)|(\s*$)/gi,"");
		s = s.replace(/[ ]{2,}/gi," ");
		s = s.replace(/\n /,"\n");
		return s.split(' ').length;
	}
	
	
	
	function computeRateByUnit() {
		
            var rate = parseInt($scope.selectedCartItemOnPopUp.rate);
            var freeUnit = parseInt($scope.selectedCartItemOnPopUp.freeUnit);
            var unitLot = parseInt($scope.selectedCartItemOnPopUp.unitVal);

            if ($scope.selectedCartItemOnPopUp.description == '') {
                
            }
            else {
                var text = $scope.selectedCartItemOnPopUp.description;
                var total_unit;
                if ($scope.selectedCartItemOnPopUp.unit == "Word") {
                	total_unit = countWords(text);
                }
                
                if ($scope.selectedCartItemOnPopUp.unit == "Line") {
                	total_unit = Math.ceil(text.length / 23);
                }
                
                if (total_unit > freeUnit) {
                   var cost = $scope.selectedCartItemOnPopUp.extra;
                   var costt = parseInt(cost, 10);
                   var extraUnit = total_unit - freeUnit;
                   var totalCost = rate + (costt * (extraUnit/unitLot));
                   $scope.selectedCartItemOnPopUp.extraUnit = extraUnit;
                   $scope.selectedCartItemOnPopUp.extraCost = totalCost - rate;
                   $scope.selectedCartItemOnPopUp.total = totalCost;
                }
                else {
                	$scope.selectedCartItemOnPopUp.total = rate;
                    $scope.selectedCartItemOnPopUp.extraCost = 0;
                }
                $scope.selectedCartItemOnPopUp.totalUnit = total_unit;
            }
            console.log($scope.selectedCartItemOnPopUp);
	}
	
	
}]);

angular.module('adschela').controller("ApplicationController",['$scope','ngDialog',
                                                               function($scope,ngDialog){
	$scope.carts = [];
	
	PushToCart = function(c) {
		$scope.carts.push(c);
	}
	
	DeleteCartItemByRate = function(rate){
		  angular.forEach($scope.carts, function(obj, index){
		    if ((rate.$$hashKey === obj.hashKey) || (rate.hashKey === obj.hashKey)) {
		    	$scope.carts.splice(index, 1);
		    	return;
		    };
		  });
	}
	
	function CloneToCartItem(fromCart, fromScreen) {
		fromCart.description=fromScreen.description;
		fromCart.total=fromScreen.total;
		fromCart.dates=angular.copy(fromScreen.dates);
		fromCart.isHindi=fromScreen.isHindi;
	    
	}
	
	SaveToCart = function(item) {
		angular.forEach($scope.carts, function(obj, index){
		    if ((item.$$hashKey === obj.hashKey) || (item.hashKey === obj.hashKey)) {
		    	CloneToCartItem($scope.carts[index],item);
		    	//$scope.carts[index] = angular.copy(item);
		    	return;
		    };
		  });
	}
	
	$scope.removeFromCart = function (c) {
		DeleteCartItemByRate(c);
	}
	
	$scope.updateCartItem = function (c) {
		ComposeAd(c);
	}
	
	
	$scope.selectedCartItemOnPopUp = {};
	SetSelectedCartItemOnPopUp = function(c) {
		$scope.selectedCartItemOnPopUp = angular.copy(c);
	}
	
	GetSelectedCartItemOnPopUp = function() {
		return $scope.selectedCartItemOnPopUp;
	}
	
	ComposeAd = function(c, scope) {
		SetSelectedCartItemOnPopUp(c);
		ngDialog.open({
			template: 'newtheme/composeAd.html',
			//scope: scope,
			controller:'ComposeAdController',
			className: 'ngdialog-theme-default'
		});
	}
	
	InitDatepicker = function() {
		$("#_datepicker").datepicker({
			multidate : true,
            format : "dd/mm/yyyy", 
            todayHighlight : true,
            startDate : $scope.selectedCartItemOnPopUp.startDate
        }).on("changeDate", function(e){
        	$scope.selectedCartItemOnPopUp.dates = e.dates;
        });
	}
	
	
	
}]);

angular.module('adschela').controller("TextClassifiedController",['$scope',function($scope){
	$scope.init = function(beData) {
		$scope.requestScope = beData;
	} 	
}]);

angular.module('adschela').controller("SidebarController",['$scope',function($scope){
	$scope.init = function(beData) {
		$scope.sideRequest = beData;
		console.log($scope.sideRequest);
	}
	 	
}]);

angular.module('adschela').controller("MakeBookingController",['$scope','$http','ngDialog',
                                                               function($scope,$http,ngDialog){
	
	$scope.init = function(beData) {
		$scope.bookingRequest = beData;
		/*console.log($scope.bookingRequest);*/
	}
	
	$scope.bookingState = {
			selectedMainCategoty: '',
			selectedNewsPaper:''
	}
	
	$scope.onCatSelected = function(cat) {
		$scope.bookingState.selectedMainCategoty = cat;
		$scope.rc.sampleWizard.forward()
	}
	
	$scope.onCitySelect =function(){
		$http.get("getBasicRateByLocationAndCategory/"+$scope.bookingState.selectedCity+'/'+$scope.bookingState.selectedMainCategoty)
		.success(function(data){
			$scope.rates = data.rates;
		});
	}
$scope.onNewspaperSelect = function() {
		
		$http.get("getRatesByNewspaper/"+$scope.bookingState.selectedNewsPaper+'/'+$scope.bookingState.selectedMainCategoty)
				.success(function(data){
					$scope.rates = data.rates;
				});
	}

	function NewCartItem(rate) {
		return cartItem = {
			hashKey: rate.$$hashKey,	
			location: rate.location,
			newspaper: rate.newspaper,
			rate: rate.rate,
			unit: rate.unit,
			unitVal: rate.unitVal,
			extra: rate.extra,
			freeUnit: rate.freeUnit,
			
			description: '',
			total: 0,
			noOfImpression: '',
			dates: [],
			mainCategoty: $scope.bookingState.selectedMainCategoty,
			isHindi:false,
			startDate:moment().add(2, 'days').format("DD/MM/YYYY")
	    }
	}
	

	$scope.onStateSelect = function() {
		console.log($scope.bookingState.selectedState);
		$http.get("getcity/"+$scope.bookingState.selectedState)
		.success(function(data){
			$scope.cities = data;
		});
	}
	
	
	$scope.rateClicked = function(e, rate) {
		if($(e.target).is(":checked")) {
			PushToCart(NewCartItem(rate, $scope.bookingState.selectedNewsPaper));
		} else {
			DeleteCartItemByRate(rate);
		}
	}
	
	$scope.rateClicked1 = function(e, rate) {
		if($(e.target).is(":checked")) {
			PushToCart(NewCartItem(rate, $scope.bookingState.selectedCity));
		} else {
			DeleteCartItemByRate(rate);
		}
	}
	
	$scope.selectedCartItemOnPopUp = {};
	
	$scope.composeAd = function(c) {
		ComposeAd(c,$scope);
	}
	
	 	
}]);
