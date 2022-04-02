<template>
    <footer id="footer">
        <!-- <ul class="icons">
            <li><router-link to="https://github.com/Jenny0122/Kosa_4_ChatBot_Project"><font-awesome-icon icon="fa-brands fa-github" /></router-link></li>
        </ul> -->
        <ul class="copyright">
            <li>&copy; 4PRINCESS.</li>
        </ul>
    </footer>
</template>
<style scoped>
#footer {
    padding: 6em 0 4em 0;
    background-color: #1d242a;
    background-color: rgba(29, 36, 42, 0.9);
    text-align: center;
    min-height: 100%;
}

#footer .icons {
    font-size: 1.25em;
}

#footer .icons a {
    color: rgba(255, 255, 255, 0.5);
}

#footer .icons a:hover {
    color: #fff;
}

#footer .copyright {
    color: rgba(255, 255, 255, 0.5);
    font-size: 0.8em;
    letter-spacing: 0.225em;
    list-style: none;
    padding: 0;
    text-transform: uppercase;
}

#footer .copyright li {
    border-left: solid 1px rgba(255, 255, 255, 0.5);
    display: inline-block;
    line-height: 1em;
    margin-left: 1em;
    padding-left: 1em;
}

#footer .copyright li:first-child {
    border-left: 0;
    margin-left: 0;
    padding-left: 0;
}

#footer .copyright li a {
    color: inherit;
}

#footer .copyright li a:hover {
    color: #fff;
}

@media screen and (max-width: 480px) {
    #footer .copyright li {
        border: 0;
        display: block;
        line-height: 1.65em;
        margin: 0;
        padding: 0.5em 0;
    }
}

@media screen and (max-width: 980px) {
    #footer {
        padding: 4em 3em 2em 3em;
    }
}

@media screen and (max-width: 736px) {
    #footer {
        padding: 3em 2em 1em 2em;
    }
}
</style>