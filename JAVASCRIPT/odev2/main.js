const ul = document.querySelector('ul');
const li = document.getElementsByTagName('li');
const close = document.getElementsByClassName('close');

for (let i = 0; i < li.length; i++) {
  const span = document.createElement('SPAN');
  const newTask = document.createTextNode('\u00D7');
  span.className = 'close';
  span.appendChild(newTask);
  li[i].appendChild(span);
}

const onClose = () => {
  for (let i = 0; i < close.length; i++) {
    close[i].onclick = () => {
      const div = this.parentElement;
      div.style.display = 'none';
    };
  }
};

function onFinish() {
  this.classList.toggle('checked');
}

function newElement() {
  const liTag = document.createElement('li');
  const inputValue = document.getElementById('task').value;
  const newTask = document.createTextNode(inputValue);
  liTag.appendChild(newTask);

  if (inputValue === '' || inputValue.replace(/^\s+|\s+$/g, '').length == 0) {
    $('.error').toast('show');
  } else {
    $('.success').toast('show');
    liTag.onclick = onFinish;
    document.getElementById('list').appendChild(liTag);
  }
  document.getElementById('task').value = '';

  const span = document.createElement('span');
  const txt = document.createTextNode('×');
  span.className = 'close';
  span.appendChild(txt);
  liTag.appendChild(span);
  onClose();
}
