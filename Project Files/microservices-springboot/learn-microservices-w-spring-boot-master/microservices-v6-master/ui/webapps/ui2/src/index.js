import _ from 'lodash';

function sum(a, b) {
    return a + b;
}

function component() {
  const element = document.createElement('div');
  
  element.innerHTML = _.join(['Hello', 'webpack'], ' ');
  
  return element;
}
  
document.body.appendChild(component());

module.exports = sum;