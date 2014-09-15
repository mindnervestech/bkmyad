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

angular.module('adschela').controller('AddCategorySubcatController',function($scope, $modal, $http, $filter, CategoryService){
	
	console.log("----------------------");
	
	$scope.cname = " ";
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

	
	$scope.Category = CategoryService.StateCityInfo.get({cname:$scope.cname,currentPage:currentPage},function(response) {
		totalPages = $scope.Category.totalPages;
		currentPage = $scope.Category.currentPage;
		$scope.pageNumber = $scope.Category.currentPage;
		$scope.pageSize = $scope.Category.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
		$scope.searchCategory = function(page) {
		if(angular.isUndefined($scope.cname) || $scope.cname=="") {
			console.log('inside function');
			$scope.cname = " ";
		}
		currentPage = page;
		
		$scope.Category = CategoryService.StateCityInfo.get({cname:$scope.cname,currentPage:currentPage},function(response) {
			console.log($scope.Category.totalPages);
			totalPages = $scope.Category.totalPages;
			currentPage = $scope.Category.currentPage;
			$scope.pageNumber = $scope.Category.currentPage;
			$scope.pageSize = $scope.Category.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	};
		
	$scope.saveCategory = function() {
	
      $http.post('/saveCategory', $scope.formData).success(function(data){
			console.log('success');
			$scope.searchCategory(currentPage);
			$('#myModal').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR');
		});
	};

	$scope.setData = function(ancmt) {
		
		$scope.ancmtData = ancmt;
		$scope.ancmtData.Sucategory='';
		$('#myModal2').modal();
				
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
		
	$scope.updateCategory = function() {
		
		$http.post('/updateSucategory', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchCategory(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};

	$scope.onNext = function() {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchCategory(currentPage);
		}
	};
	$scope.onPrev = function() {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchCategory(currentPage);
		}
	};
	
});
angular.module('adschela').service('CategoryService',function($resource){
    this.StateCityInfo = $resource(
            '/getCategory/:cname/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});



angular.module('adschela').controller('AddStateCityController',function($scope, $modal, $http, $filter, StateCityService){
	
	
	$scope.Statename = " ";
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

	
	$scope.State = StateCityService.StateCityInfo.get({Statename:$scope.Statename,currentPage:currentPage},function(response) {
		totalPages = $scope.State.totalPages;
		currentPage = $scope.State.currentPage;
		$scope.pageNumber = $scope.State.currentPage;
		$scope.pageSize = $scope.State.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
		$scope.searchState = function(page) {
			
		if(angular.isUndefined($scope.Statename) || $scope.Statename=="") {
			console.log('inside function');
			$scope.Statename = " ";
		}
		currentPage = page;
		
		$scope.State = StateCityService.StateCityInfo.get({Statename:$scope.Statename,currentPage:currentPage},function(response) {
			console.log($scope.State.totalPages);
			totalPages = $scope.State.totalPages;
			currentPage = $scope.State.currentPage;
			$scope.pageNumber = $scope.State.currentPage;
			$scope.pageSize = $scope.State.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	};
		
	$scope.saveState = function() {
	
      
      $http.post('/saveCity', $scope.formData).success(function(data){
			console.log('success');
			$scope.searchState(currentPage);
			$('#myModal').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR');
		});
	};

	$scope.setData = function(ancmt) {
		
		$scope.ancmtData = ancmt;
		$scope.ancmtData.Cityname='';
		$('#myModal2').modal();
				
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
		
	$scope.updateState = function() {
		
		$http.post('/updateState', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchState(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};

	$scope.onNext = function() {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchState(currentPage);
		}
	};
	$scope.onPrev = function() {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchState(currentPage);
		}
	};
	
});
angular.module('adschela').service('StateCityService',function($resource){
    this.StateCityInfo = $resource(
            '/getStateName/:Statename/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});




angular.module('adschela').controller('AddNewspaperController',function($scope, $modal, $http, $filter, NewpaperService,deleteNewpaperService,getNewspaperservice,getCityNameservice,getStateNameservice,getcnameservice,announcementIconService){
	
	
	$scope.Nameofthenewspaper = " ";
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

	
	$scope.Newspaper = NewpaperService.NewspaperInfo.get({Nameofthenewspaper:$scope.Nameofthenewspaper,currentPage:currentPage},function(response) {
		totalPages = $scope.Newspaper.totalPages;
		currentPage = $scope.Newspaper.currentPage;
		$scope.pageNumber = $scope.Newspaper.currentPage;
		$scope.pageSize = $scope.Newspaper.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
		$scope.searchNewspaper = function(page) {
		if(angular.isUndefined($scope.Nameofthenewspaper) || $scope.Nameofthenewspaper=="") {
			console.log('inside function');
			$scope.Nameofthenewspaper = " ";
		}
		currentPage = page;
		
		$scope.Newspaper = NewpaperService.NewspaperInfo.get({Nameofthenewspaper:$scope.Nameofthenewspaper,currentPage:currentPage},function(response) {
			console.log($scope.Newspaper.totalPages);
			totalPages = $scope.Newspaper.totalPages;
			currentPage = $scope.Newspaper.currentPage;
			$scope.pageNumber = $scope.Newspaper.currentPage;
			$scope.pageSize = $scope.Newspaper.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	};
		
	$scope.saveNewspaper = function() {
		
		console.log($scope.formData.NameofCities);
		$scope.formData.BasicratesperText="/"+$scope.formData.Value+" "+$scope.formData.Unit;
			
      $http.post('/saveNewpaper', $scope.formData).success(function(data){
			console.log('success');
			$scope.searchNewspaper(currentPage);
			$('#myModal').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR');
		});
	};
	
	$scope.setData = function(ancmt) {
	
		 console.log(ancmt);
		$scope.resultstate = getStateNameservice.Allstate.get();
		$scope.resultCity = [{cityname:ancmt.Nameofcities}];
		console.log("------"+$scope.resultCity+"----++");
		$scope.ancmtData = ancmt;
		$('#myModal2').modal();
				
	};
	$scope.onStateselect = function() {
		alert("State"+$scope.formData.Statename)
		$scope.resultCity = getCityNameservice.AllCity.get({state:$scope.formData.Statename}); 
		}
	$scope.onStateselectupdate = function() {
		alert("State"+$scope.ancmtData.Statename)
		$scope.resultCity = getCityNameservice.AllCity.get({state:$scope.ancmtData.Statename}); 
		}
	
	$scope.setDates = function() {
				
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
		$scope.deleteId = Id.NewsId;
		console.log("-**-*-"+$scope.deleteId+"*-*-*-*");
		$('#myModal3').modal();
	};
	
	$scope.updateNewspaper = function() {
		console.log($scope.ancmtData);
		$scope.formData.BasicratesperText="/"+$scope.formData.Value+" "+$scope.formData.Unit;
		$http.post('/updateNewpaper', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchNewspaper(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};
	
	$scope.deleteNewspaper = function() {
		deleteNewpaperService.Deletenewspaper.get({id :$scope.deleteId}, function(data){
			$scope.searchNewspaper(currentPage);
            $('#myModal3').modal('hide');
		});    
	};
	
	/*$scope.selectedFiles = [];
	$scope.dataUrls = [];
	$scope.tempSelectedFiles = [];
	$scope.onFileSelect = function($files) {
		console.log("Hello");
		if($scope.selectedFiles.length == 0) {
			$scope.tempSelectedFiles = [];
		}
	
		$scope.selectedFiles.push($files);
		$scope.tempSelectedFiles.push($files);
		for ( var i = 0; i < $files.length; i++) {
			var $file = $files[i];
			if (window.FileReader && $file.type.indexOf('image') > -1) {
			var fileReader = new FileReader();
			fileReader.readAsDataURL($files[i]);
				var loadFile = function(fileReader, index) {
					fileReader.onload = function(e) {
						$timeout(function() {
							$scope.dataUrls.push(e.target.result);
						});
					}
				}(fileReader, i);
			}
		}
		alert("selectedFile :: "+$scope.selectedFiles.length);
	};*/
	
	/*$upload.upload({
        url : '/image/uploadPhoto',
        method: $scope.httpMethod,
        data : {
            newsPaperId : id
        },
        file: $scope.commentTempSelectedFiles[i],
        fileFormDataName: 'photo'
    });*/
	
	$scope.onNext = function() {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchNewspaper(currentPage);
		}
	};
	$scope.onPrev = function() {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchNewspaper(currentPage);
		}
	};
	
});
angular.module('adschela').service('NewpaperService',function($resource){
    this.NewspaperInfo = $resource(
            '/getNewpaper/:Nameofthenewspaper/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});

angular.module('adschela').service('deleteNewpaperService',function($resource){
    this.Deletenewspaper = $resource(
            '/deleteNewpaper/:id',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});

angular.module('adschela').controller('AddBasicRateController',function($scope, $modal, $http, $filter, BasicRateService,getNewspaperservice,getCityNameservice,getStateNameservice,getcnameservice, deleteBasicRateService, announcementIconService){

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

	
	$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
		totalPages = $scope.BasicRate.totalPages;
		currentPage = $scope.BasicRate.currentPage;
		$scope.pageNumber = $scope.BasicRate.currentPage;
		$scope.pageSize = $scope.BasicRate.totalPages;
		
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
		$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
			console.log($scope.BasicRate.totalPages);
			totalPages = $scope.BasicRate.totalPages;
			currentPage = $scope.BasicRate.currentPage;
			$scope.pageNumber = $scope.BasicRate.currentPage;
			$scope.pageSize = $scope.BasicRate.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	    console.log($scope.BasicRate);
	};
	console.log($scope.City);
	console.log($scope.BasicRate);
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
		$scope.resultCity = [{cityname:ancmt.City}];
		$scope.ancmtData = ancmt;
		$('#myModal2').modal();
		
			
	};

	$scope.onStateselect = function() {
		alert("State"+$scope.formData.Statename)
		$scope.resultCity = getCityNameservice.AllCity.get({state:$scope.formData.Statename}); 
		}
	$scope.onStateselectupdate = function() {
		alert("State"+$scope.ancmtData.Statename)
		$scope.resultCity = getCityNameservice.AllCity.get({state:$scope.ancmtData.Statename}); 
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
		deleteBasicRateService.Deletebasicrate.get({id :$scope.deleteId}, function(data){
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
    this.BasicRateInfo = $resource(
            '/getBasicrate/:City/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});

angular.module('adschela').service('deleteBasicRateService',function($resource){
    this.Deletebasicrate = $resource(
            '/deleteBasicRate/:id',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});



	













angular.module('adschela').controller("ComposeAdController",['$scope',function($scope){
	$scope.selectedCartItemOnPopUp = GetSelectedCartItemOnPopUp();
	var borderSelected;
	var totalCost;
	var borderColor;
	var backgroundColor;
	var rate;
	var checkColorSelected;
	var savenameofcolorSelected;
        var bgColorSelected=$scope.selectedCartItemOnPopUp.onbgColorchange
	borderColor=parseInt($scope.selectedCartItemOnPopUp.extraForBorder);
	 backgroundColor=parseInt($scope.selectedCartItemOnPopUp.extraForBackgroud);
	 
	 
	  
	
	$scope.selectedCartItemOnPopUp.onBorderSelected='No';
	$scope.onBorderselected = function(){
		//$scope.selectedCartItemOnPopUp.onBorderSelected='No';
		console.log($scope.selectedCartItemOnPopUp.onBorderSelected);
		if($scope.selectedCartItemOnPopUp.onBorderSelected == 'Yes') {
			$scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost + borderColor;
		} else {
			$scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost - borderColor;
		}
		ReTotal();
     }

	
	
	  $scope.onNoBgcolorSelected=function(){
		//ReTotal();
		  if($scope.selectedCartItemOnPopUp.nobgColor) { 
		      $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost - backgroundColor;
		  }
		  else {
			  $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost + backgroundColor;
		  }
		  ReTotal();
	}
	
	$scope.onComposeAdStepChange = function() {
		$scope.rc.composeWizard.forward();
		
		if($scope.rc.composeWizard.currentIndex === 1) {
			
		}
		
		if($scope.rc.composeWizard.currentIndex == 2) {
			InitDatepicker();
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
                	$scope.selectedCartItemOnPopUp.totalUnitCost = totalCost;
                	$scope.selectedCartItemOnPopUp.extraUnit = extraUnit;
                	
                	ReTotal();
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
		fromCart.fullTotal=fromScreen.fullTotal;
		fromCart.dates=angular.copy(fromScreen.dates);
		fromCart.isHindi=fromScreen.isHindi;
		fromCart.extraCost=fromScreen.extraCost;
		fromCart.totalUnit=fromScreen.totalUnit;
		fromCart.rate=fromScreen.rate;
		fromCart.onbgColorchange=fromScreen.onbgColorchange;
		fromCart.onBorderSelected=fromScreen.onBorderSelected;
		fromCart.nobgColor=fromScreen.nobgColor;
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
	
	ReTotal = function () {
		$scope.selectedCartItemOnPopUp.fullTotal = $scope.selectedCartItemOnPopUp.noOfImpression * 
		($scope.selectedCartItemOnPopUp.totalUnitCost + $scope.selectedCartItemOnPopUp.totalExtraCost);
		console.log($scope.selectedCartItemOnPopUp.fullTotal);
	}
	
	InitDatepicker = function() {
		var costAfterTopping = $scope.selectedCartItemOnPopUp.total;
		$("#_datepicker").datepicker({
			multidate : true,
            format : "dd/mm/yyyy", 
            todayHighlight : true,
            startDate : $scope.selectedCartItemOnPopUp.startDate
        }).on("changeDate", function(e){
        	// TODO: If we dont put apply function , first time total is not applied on screen
        	$scope.$apply(function(){
        	var NumberOfDate=0;
        	$scope.selectedCartItemOnPopUp.dates = e.dates;
        	$scope.selectedCartItemOnPopUp.noOfImpression = $scope.selectedCartItemOnPopUp.dates.length;
        	ReTotal();
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
	$scope.showFieldsVar = false;
	$scope.userId;
	/*$scope.khandobaVar = false;*/
	console.log("mainCategoty"+$scope.userid);
	
	$scope.address={
			pinCode:'',
			fullName:'',
			shippingAddress:'',
			nearestLandmark:'',
			city:'',
			state:'',
			mobile:'',
			landline:''
			//userid:$scope.userid
	};
	$scope.showfieldsonlyusername=function(showfieldstouser)
	{
		$scope.showFieldsVar = false;
	}
	$scope.showHomeShipingDetails=function(showHomeshipping){
		$scope.showHomeshipping=true;
		$scope.cashByHome;
		console.log("$scope.cashByHome:"+$scope.cashByHome);
		$scope.showDebitCardshipping=false;
	}
	
	$scope.showDebitShipingDetails=function(showDebitCardshipping){
		$scope.showHomeshipping=false;
		$scope.showDebitCardshipping=true;
		$scope.cashbyDebit;
		
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
			fullTotal: 0,
			totalExtraCost : 0,
			totalUnitCost: 0,
			noOfImpression: 1,
			dates: [],
			mainCategoty: $scope.bookingState.selectedMainCategoty,
			isHindi:false,
			onbgColorchange:'',
			onBorderSelected:'Yes',
			nobgColor:'',
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
		$http({method:"POST",url:"/submit-cart",
			data:{
				carts: $scope.carts,
				address:$scope.address,
				email:$scope.userId,
				modeOfPayment:$scope.modeOfPayment
			}
		}).success(function(){
				
			});
	}
	 	
}]);
