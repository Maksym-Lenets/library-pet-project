$.fn.jsonToForm = function (data, callbacks) {
  var formInstance = this;

  var options = {
    data: data || null,
    callbacks: callbacks,
  };

  if (options.data != null) {
    $.each(options.data, function (k, v) {
      var elements = $('[name^="' + k + '"]', formInstance);
      console.log("elements: " + elements);
      console.log("==========");
      console.log(k +": "+ v);

      if (options.callbacks != null && options.callbacks.hasOwnProperty(k)) {
        options.callbacks[k](v);
        return;
      }

      $(elements).each(function (index, element) {
        console.log(index +": "+ element);
        if (Array.isArray(v)) {
          v.forEach(function (val) {
            console.log("===="+ index +": "+ element +": "+ val);
            $(element).is("select")
              ? $(element)
                  .find("[value='" + val + "']")
                  .prop("selected", true)
              : $(element).val() == val
              ? $(element).prop("checked", true)
              : "";
          });
        } else if ($(element).is(":checkbox") || $(element).is(":radio")) {
          // checkbox group or radio group
          $(element).val() == v ? $(element).prop("checked", true) : "";
        } else {
          $('[name="' + k + '"]', formInstance).val(v);
        }
      });
    });
  }
};
