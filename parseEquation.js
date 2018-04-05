var _ = require('underscore');

function doSomething() {
  var input = "1b30 + 3b10 - 50 + 6b90 * 3";
  
  var tokens = input.split(" ")
  
  var fullString = "";
  
  for(var i = 0;i<tokens.length;i++){
    if(tokens[i].indexOf("b") >= 0){
      var tokenComponents = tokens[i].split("b");
      var tokenValue = tokenComponents[0] * tokenComponents[1];
      fullString += tokenValue;
    }
    else {
      fullString += tokens[i];
    }
  }
  
  console.log(fullString);
  
  console.log(eval(fullString));
  
  
}

doSomething();