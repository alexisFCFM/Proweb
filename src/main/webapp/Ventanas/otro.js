const wrapper =document.querySelector('.wrapper');
const loginLink =document.querySelector('.login-link');
const registerLink =document.querySelector('.register-link');
const btnpopup =document.querySelector('.btnLogin_popup');
const btnclose =document.querySelector('.icon-close');

registerLink.addEventListener('click', ()=>{
wrapper.classList.add('active')

});

loginLink.addEventListener('click', ()=>{
    wrapper.classList.remove('active')
    
});

btnpopup.addEventListener('click', ()=>{
    wrapper.classList.add('active-popup')
    
 });

    btnclose.addEventListener('click', ()=>{
        wrapper.classList.remove('active-popup')
        
});