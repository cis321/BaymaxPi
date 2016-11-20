'use strict';

/* globals baymaxPiApp */
baymaxPiApp.factory('StateService', [ function () {
  var msgBus = {};

  msgBus.set = function (value) {
    msgBus.value = value;
  };

  msgBus.get = function () {
    return msgBus.value;
  };

  return msgBus;
}, ]);
