// 1.1 Real-time Date and Time Display in the right corner
function updateDateTime() {
    const now = new Date();
    document.getElementById('datetime').innerText = now.toLocaleString();
}
setInterval(updateDateTime, 1000);
updateDateTime();

// 1.4 Inactivity Alert (3 minutes timer)
setTimeout(() => {
    alert("3 mins past");
}, 3 * 60 * 1000);

// 1.3 Form Validation
function validateForm(event) {
    event.preventDefault();
    let isValid = true;

    // Helper: Reset errors
    document.querySelectorAll('.error').forEach(el => el.innerText = '');

    const firstName = document.getElementById('firstName').value.trim();
    const lastName = document.getElementById('lastName').value.trim();
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    const genderSelected = document.querySelector('input[name="gender"]:checked');
    const mobile = document.getElementById('mobile').value.trim();
    const dob = document.getElementById('dob').value.trim();
    const email = document.getElementById('email').value.trim();

    // First Name Validation (alphabetic only)
    const nameRegex = /^[A-Za-z]+$/;
    if (!firstName) {
        document.getElementById('firstNameErr').innerText = 'First name must be entered.';
        isValid = false;
    } else if (!nameRegex.test(firstName)) {
        document.getElementById('firstNameErr').innerText = 'First name must contain characters only.';
        isValid = false;
    }

    // Last Name Validation (alphabetic only)
    if (!lastName) {
        document.getElementById('lastNameErr').innerText = 'Last name must be entered.';
        isValid = false;
    } else if (!nameRegex.test(lastName)) {
        document.getElementById('lastNameErr').innerText = 'Last name must contain characters only.';
        isValid = false;
    }

    // Password Validation (6-20 characters)
    if (!password) {
        document.getElementById('passwordErr').innerText = 'Password must be entered.';
        isValid = false;
    } else if (password.length < 6 || password.length > 20) {
        document.getElementById('passwordErr').innerText = 'Password length must be between 6 and 20 characters.';
        isValid = false;
    }

    // Confirm Password Validation
    if (!confirmPassword) {
        document.getElementById('confirmPasswordErr').innerText = 'Please confirm your password.';
        isValid = false;
    } else if (confirmPassword !== password) {
        document.getElementById('confirmPasswordErr').innerText = 'Passwords do not match.';
        isValid = false;
    }

    // Gender Validation
    if (!genderSelected) {
        document.getElementById('genderErr').innerText = 'Gender must be selected.';
        isValid = false;
    }

    // Mobile Validation (XXX-XXX-XXXX, XXX.XXX.XXXX, or XXX XXX XXXX)
    const mobileRegex = /^(\d{3}-\d{3}-\d{4}|\d{3}\.\d{3}\.\d{4}|\d{3}\s\d{3}\s\d{4})$/;
    if (!mobile) {
        document.getElementById('mobileErr').innerText = 'Mobile number must be entered.';
        isValid = false;
    } else if (!mobileRegex.test(mobile)) {
        document.getElementById('mobileErr').innerText = 'Format must be XXX-XXX-XXXX, XXX.XXX.XXXX, or XXX XXX XXXX.';
        isValid = false;
    }

    // DOB Validation (DD-MM-YYYY)
    const dobRegex = /^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\d{4}$/;
    if (!dob) {
        document.getElementById('dobErr').innerText = 'Date of birth must be entered.';
        isValid = false;
    } else if (!dobRegex.test(dob)) {
        document.getElementById('dobErr').innerText = 'Date of birth must follow DD-MM-YYYY format.';
        isValid = false;
    }

    // Email Validation: contains @ and ., @ not 1st char, last dot >= 1 char after @
    if (!email) {
        document.getElementById('emailErr').innerText = 'Email must be entered.';
        isValid = false;
    } else {
        const atIndex = email.indexOf('@');
        const lastDotIndex = email.lastIndexOf('.');

        if (atIndex <= 0 || lastDotIndex === -1 || lastDotIndex <= atIndex + 1) {
            document.getElementById('emailErr').innerText = 'Invalid email format (must contain @, . and valid placement).';
            isValid = false;
        }
    }

    if (isValid) {
        alert('Form submitted successfully!');
        document.getElementById('signupForm').reset();
    }

    return isValid;
}