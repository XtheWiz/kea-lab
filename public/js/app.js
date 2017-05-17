angular.module('kea-lab', [])
    .controller('ReportController', function($scope, $http) {
        var process_statuses = {
            'idle' : 'Please click button to generate report',
            'processing' : 'Processing, please wait',
            'finish' : 'Reponse : '
        }
        var report = this;
        $scope.status = process_statuses.idle;

        report.makeReport = function() {
            $scope.status = process_statuses.processing;
            $http.get("http://localhost:9000/report", {
                params: {appId: report.appId}
            }).then(function(response){
                $scope.status = process_statuses.finish;
                $scope.messages = response.data.messages;
                console.log(response);
            });
        }
});