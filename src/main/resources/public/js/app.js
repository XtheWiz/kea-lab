var myApp = angular.module('kea-lab', [])
    .controller('ReportController', function($scope, $http) {
        var process_statuses = {
            'idle' : 'Please click button to generate report',
            'error' : 'Error Occerrued:',
            'processing' : 'Processing, please wait',
            'finish' : 'Reponse : '
        }
        var hostname = location.host;
        var report = this;
        $scope.status = process_statuses.idle;

        report.makeReport = function() {
            console.log("Click : " + hostname);
            $scope.messages = [];
            $scope.status = process_statuses.processing;
            $http.get("http://"+hostname+"/report", {
                params: {appId: report.appId}
            }).then(function(response){
                $scope.status = process_statuses.finish;
                $scope.messages = response.data.messages;
                console.log(response);
            }, function(response) {
                $scope.status = process_statuses.error;
                $scope.messages = response;
                console.log(response);
            });
        }
});