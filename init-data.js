
var jcontent =  {
  "name"        : "Ali Mounir",
  "job"         : "Student at University Stuttgart",
  "address"     : "Cairo, Egypt",
  "birthdate"   : "March 7th 2002",
  "email"       : "alimounir456@gmail.com",
  "phone"       : "+201098847771",
  "insta"       : "_alimounir",
  "github"      : "AliMounir"
};

var newName = document.getElementById('name');
newName.innerHTML = "&nbsp;" + jcontent.name + "&nbsp;";

var newJob = document.getElementById('job');
newJob.innerHTML = "<i class='fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-blue'></i>" + jcontent.job;

var newAddress = document.getElementById('address');
newAddress.innerHTML = "<i class='fa fa-home fa-fw w3-margin-right w3-large w3-text-blue'></i>" + jcontent.address;

var newBirthdate = document.getElementById('birthdate');
newBirthdate.innerHTML = "<i class='fa fa-birthday-cake fa-fw w3-margin-right w3-large w3-text-blue'></i>" + jcontent.birthdate;

var newEmail = document.getElementById('email');
newEmail.innerHTML = "<i class='fa fa-envelope fa-fw w3-margin-right w3-large w3-text-blue'></i>" + jcontent.email;

var newPhone = document.getElementById('phone');
newPhone.innerHTML = "<i class='fa fa-phone fa-fw w3-margin-right w3-large w3-text-blue'></i>" + jcontent.phone;

var newInsta = document.getElementById('insta');
newInsta.innerHTML = "<i class='fa fa-instagram fa-fw w3-margin-right w3-large w3-text-blue'></i>@" + jcontent.insta;

var newGithub = document.getElementById('github');
newGithub.innerHTML = "<i class='fa fa-code-fork fa-fw w3-margin-right w3-large w3-text-blue'></i>github.com/" + jcontent.github;