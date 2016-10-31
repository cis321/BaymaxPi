'use strict';

/* globals baymaxPiApp */
baymaxPiApp.factory('LoginService', ['$resource',
    function ($resource) {
        var url = 'http://localhost:8100/server-baymaxpi/api/authorization';
        var defaultParams = {};

        var actions = {
            createUser: {
                method: 'POST',
                isArray: false,
            },
        };

        return $resource(url, defaultParams, actions);
    },
]);
