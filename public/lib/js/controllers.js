angular.module('adschela').controller("Booknewspaperaddonline",['$scope','beData',function($scope,beData){
	$scope.forTest = beData;
}]);

angular.module('adschela').controller("HeaderController",['$scope',function($scope){
	
	$scope.isLoginError = !($("#login_error").val() == '' || $("#login_error").val() == 'undefined');
	
	
}]);
angular.module('adschela').controller("AdDisplay",['$scope','dispadData','$http',
                                                   function($scope,dispadData,$http){
	$scope.resultCategory=dispadData.categories;
	$scope.resultSubCategory =dispadData.newspapers;
    console.log(dispadData.newspapers);
    console.log(dispadData.categories);
	
	
}]);
angular.module('adschela').controller("FooterController",['$scope',function($scope){
	
}]);

angular.module('adschela').controller("PopUpController",['$scope',function($scope){
}]);
angular.module('adschela').controller("IndexController",['$scope',function($scope){
}]);