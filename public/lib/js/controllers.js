angular.module('adschela').controller("Booknewspaperaddonline",['$scope','beData',function($scope,beData){
	$scope.forTest = beData;
}]);

angular.module('adschela').controller("HeaderController",['$scope',function($scope){
}]);

angular.module('adschela').controller("FooterController",['$scope',function($scope){
}]);

angular.module('adschela').controller("IndexController",['$scope',function($scope){
	$scope.nplist = [{name:"Amar Ujala",img:"/NewDesign/np-logos/amarujala.jpg"},
	                 {name:"Danik Jagaran",img:"/NewDesign/np-logos/dainikjagaran.png"},
	                 {name:"Hindustan",img:"/NewDesign/np-logos/hindustan.jpg"},
	                 {name:"Sandhya Times",img:"/NewDesign/np-logos/sandhyatimes.jpg"},
	                 {name:"Maharashtra Times",img:"/NewDesign/np-logos/maharashtratimes.jpg"},
	                 {name:"Vijay Karnataka",img:"/NewDesign/np-logos/vijaykarnataka.jpg"},
	                 {name:"Times of India",img:"/NewDesign/np-logos/toi.jpg"},
	                 {name:"Economic Times",img:"/NewDesign/np-logos/The-Economic-Times.png"},
	                 {name:"The Hindu",img:"/NewDesign/np-logos/Hindu.png"},
	                 {name:"Mirror",img:"/NewDesign/np-logos/MUMBAi MIRROR LOGO.jpg"},
	                 {name:"Deccan Herald",img:"/NewDesign/np-logos/Deccan-Herald.png"},
	                 {name:"Navbharat Times",img:"/NewDesign/np-logos/navbharat.gif"},
	                 {name:"Rajasthan Patrika",img:"/NewDesign/np-logos/rajasthanpatrika.jpg"},
	                 {name:"Prajavani",img:"/NewDesign/np-logos/prajavani.jpg"},
	                 {name:"udyavani-head",img:"/NewDesign/np-logos/udyavani-head.gif"},
	                 {name:"Kashmir Times",img:"/NewDesign/np-logos/Kashmir Times Logo.jpg"},
	                 {name:"dainik sambad",img:"/NewDesign/np-logos/dainik sambad.jpg"},
	                 {name:"prothom alo logo",img:"/NewDesign/np-logos/prothom alo logo.jpg"},
	                 {name:"Inquilab logo",img:"/NewDesign/np-logos/Inquilab logo.jpg"},
	                 {name:"ABP",img:"/NewDesign/np-logos/ABP.png"},
	                 {name:"deccanchronicle",img:"/NewDesign/np-logos/deccanchronicle.jpg"},
	                 {name:"assamtribune",img:"/NewDesign/np-logos/assamtribune.jpg"},
	                 {name:"dailyexcelsior",img:"/NewDesign/np-logos/dailyexcelsior.jpg"},
	                 {name:"dailystar",img:"/NewDesign/np-logos/dailystar.jpg"},
	                 {name:"dainikbhaskar",img:"/NewDesign/np-logos/dainikbhaskar.jpg"},
	                 {name:"dainikjugasankha",img:"/NewDesign/np-logos/dainikjugasankha.jpg"},
	                 {name:"dharitri",img:"/NewDesign/np-logos/dharitri.jpg"},
	                 {name:"dinakaran",img:"/NewDesign/np-logos/dinakaran.jpg"},
	                 {name:"dinamalar",img:"/NewDesign/np-logos/dinamalar.jpg"},
	                 {name:"dinamani",img:"/NewDesign/np-logos/dinamani.jpg"},
	                 {name:"divyabhaskar",img:"/NewDesign/np-logos/divyabhaskar.jpg"},
	                 {name:"dna.jpg",img:"/NewDesign/np-logos/dna.jpg"},
	                 {name:"easternchronicle",img:"/NewDesign/np-logos/easternchronicle.jpg"},
	                 {name:"eenadu",img:"/NewDesign/np-logos/eenadu.jpg"},
	                 {name:"ekdin",img:"/NewDesign/np-logos/ekdin.jpg"},
	                 {name:"goamessenger",img:"/NewDesign/np-logos/goamessenger.jpg"},
	                 {name:"himalibela",img:"/NewDesign/np-logos/himalibela.jpg"},
	                 {name:"janpathsamachar",img:"/NewDesign/np-logos/janpathsamachar.jpg"},
	                 {name:"jugantor",img:"/NewDesign/np-logos/jugantor.jpg"},
	                 {name:"kannadaprabha",img:"/NewDesign/np-logos/kannadaprabha.jpg"},
	                 {name:"lokprabha",img:"/NewDesign/np-logos/lokprabha.jpg"},
	                 {name:"Lokmat",img:"/NewDesign/np-logos/Lokmat.jpg"},
	                 {name:"ajit",img:"/NewDesign/np-logos/ajit.png"},	                 	                 
	                 {name:"dainik-kashmir-times",img:"/NewDesign/np-logos/dainik-kashmir-times.png"},
	                 {name:"Gujarat Samachar.png",img:"/NewDesign/np-logos/gs-log-big.png"},
	                 {name:"image",img:"/NewDesign/np-logos/image.gif"},
	                 {name:"Divya Marathi",img:"/NewDesign/np-logos/image.jpg"},
	                 {name:"malayalamanorama",img:"/NewDesign/np-logos/malayalamanorama.jpg"},
	                 {name:"mathrubhumi",img:"/NewDesign/np-logos/mathrubhumi.jpg"},
	                 {name:"midday",img:"/NewDesign/np-logos/midday.jpg"},
	                 {name:"naiduniaepaper",img:"/NewDesign/np-logos/naiduniaepaper.jpg"},
	                 {name:"Presentation1",img:"/NewDesign/np-logos/Presentation1.pptx"},	                 	                 
	                 {name:"prothom alo logo",img:"/NewDesign/np-logos/prothom alo logo.jpg"},
	                 {name:"punjabkesri",img:"/NewDesign/np-logos/punjabkesri.jpg"},
	                 {name:"punyanagari-big",img:"/NewDesign/np-logos/punyanagari-big.png"},
	                 {name:"sakal",img:"/NewDesign/np-logos/sakal.jpg"},
	                 {name:"sakshi",img:"/NewDesign/np-logos/sakshi.jpg"},
	                 {name:"sambad",img:"/NewDesign/np-logos/sambad.jpg"},
	                 {name:"sandesh",img:"/NewDesign/np-logos/sandesh.jpg"},
	                 {name:"sandhyatimes",img:"/NewDesign/np-logos/sandhyatimes.jpg"},
	                 {name:"thenewindianexpress",img:"/NewDesign/np-logos/thenewindianexpress.jpg"},	                 	                 
	                 {name:"The-Samaj",img:"/NewDesign/np-logos/The-Samaj.png"},
	                 {name:"thesiasatdaily",img:"/NewDesign/np-logos/thesiasatdaily.jpg"},
	                 {name:"thestatesman",img:"/NewDesign/np-logos/thestatesman.jpg"},
	                 {name:"The-Telegraph",img:"/NewDesign/np-logos/The-Telegraph.png"},
	                 {name:"The-Tribune",img:"/NewDesign/np-logos/The-Tribune.png"},
	                 {name:"navbharat",img:"/NewDesign/np-logos/navbharat.gif"},
	                 {name:"navbharattimes",img:"/NewDesign/np-logos/navbharattimes.jpg"},
	                 {name:"newbline",img:"/NewDesign/np-logos/newbline.png"},	                 	                 
	                 {name:"prabhatkhabar",img:"/NewDesign/np-logos/prabhatkhabar.jpg"}];
	
	
	
	$scope.carousel= {
			interval : 5000
	}
    $scope.slides = [{
	      	image: '/NewDesign/images/classified-ad.jpg'
	    	},
		    {
			      image: '/NewDesign/images/all-np-1.jpg'
			},
	    	{
		      image: '/NewDesign/images/classified-ad-2.jpg'
		    },
		    {
			      image: '/NewDesign/images/all-np-2.jpg'
			},
		    {
			      image: '/NewDesign/images/classified-ad-3.jpg'
			},
		    {
			      image: '/NewDesign/images/all-np-3.jpg'
			},
		    {
			      image: '/NewDesign/images/classified-ad-4.jpg'
			},
		    {
			      image: '/NewDesign/images/banner11.jpg'
			}
		    ];
	  
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
                var totalCost;
                var extraUnit;
                if ($scope.selectedCartItemOnPopUp.unit == "Word") {
                	total_unit = countWords(text);
                }
                
                if ($scope.selectedCartItemOnPopUp.unit == "Line") {
                	total_unit = Math.ceil(text.length / 23);
                }
                
                if (total_unit > freeUnit) {
                   var cost = $scope.selectedCartItemOnPopUp.extra;
                   var costt = parseInt(cost, 10);
                   extraUnit = total_unit - freeUnit;
                   totalCost = rate + (costt * (extraUnit/unitLot));
                   
                }
                else {
                	totalCost = rate;
                }
                
                $scope.$apply(function(){
                	$scope.selectedCartItemOnPopUp.totalUnit = total_unit;
                	$scope.selectedCartItemOnPopUp.extraCost = totalCost - rate;
                	$scope.selectedCartItemOnPopUp.total = totalCost;
                	$scope.selectedCartItemOnPopUp.extraUnit = extraUnit;
                });
            }
            console.log($scope.selectedCartItemOnPopUp);
	}
	
	$scope.formatDate = function(cd) {
		return moment(cd).format('DD-MM-YYYY');
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
	
	$scope.formatDate = function(cd) {
		return moment(cd).format('DD-MM-YYYY');
	}
	
	InitDatepicker = function() {
		$("#_datepicker").datepicker({
			multidate : true,
            format : "dd/mm/yyyy", 
            todayHighlight : true,
            startDate : $scope.selectedCartItemOnPopUp.startDate
        }).on("changeDate", function(e){
        	$scope.$apply(function(){
        		$scope.selectedCartItemOnPopUp.dates = e.dates;
        	});
        	
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
		
		if($scope.bookingState.selectedMainCategoty == "Matrimonial"){
			$scope.checkMatrimonial = true;
				
		}else{
			$scope.checkMatrimonial = false;
		
		}
		
		$http.get('getSubCategoty/'+$scope.bookingState.selectedMainCategoty)
		.success(function(data){
			if(data) {
				$scope.resultSubCategory = data;
			} else {
				$scope.resultSubCategory = [];
			}
		});
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
