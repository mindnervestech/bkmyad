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
			interval : 6000
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
angular.module('adschela').controller('AddBasicRateController',function($scope, $modal, $http, $filter, BasicRateService,getNewspaperservice,getCityNameservice,getStateNameservice,getcnameservice, deleteBasicRateService, announcementIconService){
	
	console.log("----------------------");
	
	$scope.City = " ";
	$scope.pageNumber;
	$scope.pageSize;
	$scope.formData = "";
	var currentPage = 1;
	var totalPages;
	$scope.isChosen = false;
	
	$scope.searchForm= {
            from : new Date(),
            to : new Date()

	}

	
	$scope.announcements = BasicRateService.AnnouncementInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
		totalPages = $scope.announcements.totalPages;
		currentPage = $scope.announcements.currentPage;
		$scope.pageNumber = $scope.announcements.currentPage;
		$scope.pageSize = $scope.announcements.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	//$scope.locations = LocationService.LocationInfo.get();
	//console.log($scope.locations);
		$scope.searchBasicRate = function(page) {
		if(angular.isUndefined($scope.City) || $scope.City=="") {
			console.log('inside function');
			$scope.City = " ";
		}
		currentPage = page;
		console.log($scope.City);
		console.log(currentPage);
		$scope.announcements = BasicRateService.AnnouncementInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
			console.log($scope.announcements.totalPages);
			totalPages = $scope.announcements.totalPages;
			currentPage = $scope.announcements.currentPage;
			$scope.pageNumber = $scope.announcements.currentPage;
			$scope.pageSize = $scope.announcements.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	    console.log($scope.announcements);
	};
	console.log($scope.City);
	console.log($scope.announcements);
	console.log('mfjfjfjfjf');
	
	
	$scope.saveBasicRate = function() {
		console.log($scope.formData);
		$http.post('/saveBasicRate', $scope.formData).success(function(data){
			console.log('success');
			$scope.searchBasicRate(currentPage);
			$('#myModal').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR');
		});
	};
	
	$scope.setData = function(ancmt) {
		
		$scope.resultNewspaper = getNewspaperservice.Allnewspaper.get(); 
		$scope.resultcname = getcnameservice.Allcname.get();
		$scope.resultstate = getStateNameservice.Allstate.get();
		console.log("---------");
		console.log(ancmt);
		console.log("---------");
		$scope.ancmtData = ancmt;
		$('#myModal2').modal();
		
		console.log("/////////////////");
		console.log($scope.ancmtData);
		console.log("/////////////////");
		//$scope.icon_url = ancmt.ic.url;
        //$scope.icon_name = ancmt.ic.name;
		
		
	};

	$scope.onStateselect = function() {
		alert("State"+$scope.formData.Statename)
		$scope.resultCity = getCityNameservice.AllCity.get({state:$scope.formData.Statename}); 
		}
	
	$scope.setDates = function() {
				
		$scope.resultNewspaper = getNewspaperservice.Allnewspaper.get(); 
		$scope.resultcname = getcnameservice.Allcname.get();
		$scope.resultstate = getStateNameservice.Allstate.get();
		
		
		$scope.searchForm.from = new Date();
		$scope.searchForm.to = new Date();
		$scope.icon_id = "";
        $scope.icon_url = "";
        $scope.icon_name = "";
		$scope.formData = "";
		$scope.isChosen = false;
		$('#myModal').modal();
	}
	$scope.setDeleteId = function(Id) {
		$scope.deleteId = Id.BasicRateID;
		console.log("-**-*-"+$scope.deleteId+"*-*-*-*");
		$('#myModal3').modal();
	};
	
	$scope.updateBasicRate = function() {
		console.log($scope.ancmtData);
		$http.post('/updateBasicRate', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchBasicRate(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};
	
	$scope.deleteBasicRate = function() {
		deleteBasicRateService.DeleteAnnouncement.get({id :$scope.deleteId}, function(data){
			//$scope.announcements.results.splice($scope.announcements.results.indexOf(idData),1);
			$scope.searchBasicRate(currentPage);
            $('#myModal3').modal('hide');
		});    
	};
	
	
	
	$scope.onNext = function() {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchBasicRate(currentPage);
		}
	};
	$scope.onPrev = function() {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchBasicRate(currentPage);
		}
	};
	
});

angular.module('adschela').service('getNewspaperservice',function($resource){
    this.Allnewspaper = $resource(
            '/getNewspaper',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get',isArray:true}
            }
    );
});


angular.module('adschela').service('getcnameservice',function($resource){
    this.Allcname = $resource(
            '/getCategory',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get',isArray:true}
            }
    );
});

angular.module('adschela').service('getStateNameservice',function($resource){
    this.Allstate = $resource(
            '/getStatename',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get',isArray:true}
            }
    );
});

angular.module('adschela').service('getCityNameservice',function($resource){
    this.AllCity = $resource(
            '/getCityname/:state',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get',isArray:true}
            }
    );
});


angular.module('adschela').service('BasicRateService',function($resource){
    this.AnnouncementInfo = $resource(
            '/getBasicrate/:City/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});

angular.module('adschela').service('deleteBasicRateService',function($resource){
    this.DeleteAnnouncement = $resource(
            '/deleteBasicRate/:id',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});



angular.module('adschela').controller('ShowAnnouncementController',function($scope, $modal, $http, $filter, AnnouncementsService, deleteAnnouncementService, announcementIconService){
	
	$scope.title = " ";
	$scope.pageNumber;
	$scope.pageSize;
	$scope.formData = "";
	var currentPage = 1;
	var totalPages;
	$scope.isChosen = false;
	
	$scope.searchForm= {
            from : new Date(),
            to : new Date()

	}

	$scope.announcements = AnnouncementsService.AnnouncementInfo.get({title:$scope.title,currentPage:currentPage},function(response) {
		totalPages = $scope.announcements.totalPages;
		currentPage = $scope.announcements.currentPage;
		$scope.pageNumber = $scope.announcements.currentPage;
		$scope.pageSize = $scope.announcements.totalPages;
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	//$scope.locations = LocationService.LocationInfo.get();
	//console.log($scope.locations);
		$scope.searchAnnouncements = function(page) {
		if(angular.isUndefined($scope.title) || $scope.title=="") {
			console.log('inside function');
			$scope.title = " ";
		}
		currentPage = page;
		console.log($scope.title);
		console.log(currentPage);
		$scope.announcements = AnnouncementsService.AnnouncementInfo.get({title:$scope.title,currentPage:currentPage},function(response) {
			console.log($scope.announcements.totalPages);
			totalPages = $scope.announcements.totalPages;
			currentPage = $scope.announcements.currentPage;
			$scope.pageNumber = $scope.announcements.currentPage;
			$scope.pageSize = $scope.announcements.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	    console.log($scope.announcements);
	};
	console.log($scope.title);
	console.log($scope.announcements);
	console.log('mfjfjfjfjf');
	
	$scope.setData = function(ancmt) {
		$('#myModal2').modal();
		$scope.ancmtData = ancmt;
		$scope.icon_url = ancmt.ic.url;
        $scope.icon_name = ancmt.ic.name;
		$scope.searchForm.from = $filter('date')(new Date(ancmt.fd),'MMMM-dd-yyyy');
		$scope.searchForm.to = $filter('date')(new  Date(ancmt.td),'MMMM-dd-yyyy');
		console.log($scope.ancmtData);
		
		
	};
	$scope.setDates = function() {
		
		$scope.searchForm.from = new Date();
		$scope.searchForm.to = new Date();
		$scope.icon_id = "";
        $scope.icon_url = "";
        $scope.icon_name = "";
		$scope.formData = "";
		$scope.isChosen = false;
		$('#myModal').modal();
	}
	$scope.setDeleteId = function(Id) {
		$scope.deleteId = Id;
		$('#myModal3').modal();
	};
	$scope.saveAnnouncement = function() {
		$scope.formData.fromDate = $filter('date')(new Date($scope.searchForm.from),'yyyy-MM-dd');
		$scope.formData.toDate = $filter('date')(new Date($scope.searchForm.to),'yyyy-MM-dd');
		console.log($scope.formData);
		$http.post('/saveAnnouncement', $scope.formData).success(function(data){
			console.log('success');
			$scope.searchAnnouncements(currentPage);
			$('#myModal').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR');
		});
	};
	
	$scope.updateAnnouncement = function() {
		$scope.ancmtData.fd = $filter('date')(new Date($scope.searchForm.from),'yyyy-MM-dd');
		$scope.ancmtData.td = $filter('date')(new Date($scope.searchForm.to),'yyyy-MM-dd');
		console.log($scope.ancmtData);
		$http.post('/updateAnnouncement', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchAnnouncements(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};
	
	$scope.deleteAnnouncement = function(idData) {
		console.log(idData);
		deleteAnnouncementService.DeleteAnnouncement.get({id :idData.id}, function(data){
			//$scope.announcements.results.splice($scope.announcements.results.indexOf(idData),1);
			$scope.searchAnnouncements(currentPage);
            $('#myModal3').modal('hide');
		});    
	};
	
	$scope.onNext = function() {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchAnnouncements(currentPage);
		}
	};
	$scope.onPrev = function() {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchAnnouncements(currentPage);
		}
	};
	
});
angular.module('adschela').service('AnnouncementsService',function($resource){
    this.AnnouncementInfo = $resource(
            '/getAnnouncements/:title/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});

angular.module('adschela').service('deleteAnnouncementService',function($resource){
    this.DeleteAnnouncement = $resource(
            '/deleteAnnouncement/:id',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});

angular.module('adschela').service('announcementIconService',function($resource){
    this.getAllIcons = $resource(
            '/getAllAnnouncementIcons',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get' ,isArray:true}
            }
    );
});

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
			$scope.selectedCartItemOnPopUp.description=data;
			console.log("hinci chk"+$scope.selectedCartItemOnPopUp.description);
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
		
            rate = parseInt($scope.selectedCartItemOnPopUp.rate);
            var freeUnit = parseInt($scope.selectedCartItemOnPopUp.freeUnit);
            var borderColor=parseInt($scope.selectedCartItemOnPopUp.borderColor);
            var location=$scope.selectedCartItemOnPopUp.location;
            var newspaper=$scope.selectedCartItemOnPopUp.newspaper;
            var unitLot = parseInt($scope.selectedCartItemOnPopUp.unitVal);

            if ($scope.selectedCartItemOnPopUp.description == '') {
                
            }
            else {
                var text = $scope.selectedCartItemOnPopUp.description;
                var total_unit;
                var extraUnit;
                if ($scope.selectedCartItemOnPopUp.unit == "Words") {
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
                   //console.log("In addition"+border);
                   //alert("hi in extra word");
                }
                else {
                	totalCost = rate;
                	console.log("in totle cost"+totalCost);
                }
                if ($scope.selectedCartItemOnPopUp.unit == "Line") {
                	total_unit = Math.ceil(text.length / 23);
                }
                $scope.$apply(function(){
                	$scope.selectedCartItemOnPopUp.totalUnit = total_unit;
                	$scope.selectedCartItemOnPopUp.extraCost = totalCost - rate;
                	$scope.selectedCartItemOnPopUp.total = totalCost;
                	console.log("cost is"+borderSelected);
                	$scope.selectedCartItemOnPopUp.extraUnit = extraUnit;
                	$scope.selectedCartItemOnPopUp.location=location;
                    $scope.selectedCartItemOnPopUp.newspaper=newspaper;
                    $scope.selectedCartItemOnPopUp.rate =totalCost;
                    $scope.selectedCartItemOnPopUp.nobgColor=savenameofcolorSelected;
                    dates= $scope.selectedCartItemOnPopUp.dates;
                   
                    $scope.selectedCartItemOnPopUp.userid=email;
                    $scope.selectedCartItemOnPopUp.cashByHome=cashByHome;
                    
                    console.log( " $scope.selectedCartItemOnPopUp.cashByHome"+ $scope.selectedCartItemOnPopUp.cashByHome);
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
	
	$scope.Login = function(){
		$('#myModal').modal();
	}
	
	$scope.Register = function(){
		$('#mySignUp').modal();
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
		fromCart.extraCost=fromScreen.extraCost;
		fromCart.totalUnit=fromScreen.totalUnit;
		fromCart.rate=fromScreen.rate;
		fromCart.onbgColorchange=fromScreen.onbgColorchange;
		fromCart.onBorderSelected=fromScreen.onBorderSelected;
		fromCart.nobgColor=fromScreen.nobgColor;
		fromCart.userid=fromScreen.userid;
		fromCart.cashbyDebit=fromScreen.cashbyDebit;
		fromCart.cashByHome=fromCart.cashByHome;
		console.log("cashbyDebit: "+fromCart.cashbyDebit);
		console.log("fromCart.cashByHome"+fromCart.cashByHome);
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
		
			controller:'ComposeAdController',
			className: 'ngdialog-theme-default'
		});
	}
	
	$scope.formatDate = function(cd) {
		return moment(cd).format('DD-MM-YYYY');
	}
	
	InitDatepicker = function() {
		var costAfterTopping = $scope.selectedCartItemOnPopUp.total;
		$("#_datepicker").datepicker({
			multidate : true,
            format : "dd/mm/yyyy", 
            todayHighlight : true,
            startDate : $scope.selectedCartItemOnPopUp.startDate
        }).on("changeDate", function(e){
        	$scope.$apply(function(){
        	var NumberOfDate=0;
        	$scope.selectedCartItemOnPopUp.dates = e.dates;
        	$scope.selectedCartItemOnPopUp.total = costAfterTopping * $scope.selectedCartItemOnPopUp.dates.length;
        	});
        	
        });
		
		$("#_datepicker").datepicker("setDate", $scope.selectedCartItemOnPopUp.dates);
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
	
	$scope.address={
			pincode:'',
			
	};
	$scope.showfieldsonlyusername=function(showfieldstouser)
	{
		$scope.showFieldsVar = false;
	}
	$scope.showHomeShipingDetails=function(showHomeshipping){
		$scope.showHomeshipping=true;
		$scope.showDebitCardshipping=false;
	}
	
	$scope.showDebitShipingDetails=function(showDebitCardshipping){
		$scope.showHomeshipping=false;
		$scope.showDebitCardshipping=true;
	}
	$scope.showfields=function(showfieldstouser){
		
		$scope.showFieldsVar = true;
	}
	$scope.init = function(beData) {
	$scope.bookingRequest = beData;
		
	}
	
	$scope.bookingState = {
			selectedMainCategoty: '',
			selectedNewsPaper:''
	}
	
	$scope.onfirestNewspaperSelect = function(np) {
		console.log("//////"+$scope.bookingState.selectedNewsPaper+"/////");
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
	$scope.checkForUsernameAndPassword =function(){
		$http.get("checkusercreadientals/"+$scope.userid+'/'+$scope.userpass)
		 .success(function(data){
		  $scope.result = data;
		  if($scope.result=="false") {
		  $scope.rc.sampleWizard.forward();
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
			extraForBackgroud:rate.extraForBackgroud,
			extraForBorder:rate.extraForBorder,
			description: '',
			total: 0,
			noOfImpression: '',
			dates: [],
			mainCategoty: $scope.bookingState.selectedMainCategoty,
			isHindi:false,
			onbgColorchange:'rbnn',
			onBorderSelected:'no',
			nobgColor:'',
			userid:$scope.userid,
			cashbyDebit:$scope.cashbyDebit,
			cashByHome:$scope.cashByHome,
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
	
   $scope.onCartSubmit = function() {
     	console.log("In submit cart fun");
		//SubmitCart();
		$http({method:"POST",url:"/submit-cart",data:$scope.carts}).success(function(){
				
			});
	}
	 	
}]);
