const professorsForm = document.getElementById("professorsForm");
const parentsForm = document.getElementById("parentsForm");
const professorsBtn = document.getElementById("professorsBtn");
const parentsBtn = document.getElementById("parentsBtn");


professorsBtn.addEventListener("click", ()=>{
    professorsForm.classList.toggle("off-screen-left-form");
    parentsForm.classList.toggle("off-screen-right-form");
});

parentsBtn.addEventListener("click", ()=>{
    parentsForm.classList.toggle("off-screen-right-form");
    professorsForm.classList.toggle("off-screen-left-form");
});
