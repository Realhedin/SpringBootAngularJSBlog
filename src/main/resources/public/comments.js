var module = angular.module('Blog', ['ngResource']);

module.factory('Comment', function($resource) {
    return $resource(':username/comments', { username: '@username' });
})
    .controller('CommentsController', function($scope, Comment) {
        var url = function() {
            return {username:$scope.username||'dkorolev'};
        }

        var update = function() {
            console.log(url());
            $scope.comments = Comment.query(url());
        };

        $scope.update = update;

        update();

});