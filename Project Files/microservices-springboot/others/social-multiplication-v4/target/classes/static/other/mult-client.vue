import Vue from 'vue'
import Hello from 'hello.vue'  
    
const app = new Vue({
        el: "#app",
        data: {
            user: {
                result: null,
                alias: null
            },
            numbers: {
                multA: null,
                multB: null
            },
            gridData: [],
            erros: [],
            hasResultView: null
        },
        created() {
           this.callFactor()
        },
        methods: {
            search: function(e) {
                e.preventDefault();
                this.checkAnswer() //check answer
                this.updateStats() //get alias data
                this.callFactor();//have to call this again to get new factors
            },
            callFactor: function() {
                axios //can i make this into its own method? SO i don't have to 
                //call created
                .get("http://localhost:8080/multiplications/random")
                .then(response => {
                    this.numbers.multA = response.data.factorA;
                    this.numbers.multB = response.data.factorB;
                })
            },
            checkAnswer: function() {
                const data = { user: { alias: this.user.alias}, multiplication: {factorA: this.numbers.multA, factorB: this.numbers.multB}, resultAttempt: this.user.result};
                axios
                .post("/results", JSON.stringify(data), { headers: { "Content-type": "application/json; charset=utf-8" } })
                .then(response => {
                    if (response.data.correct) {
                        this.hasResultView = "The result is correct! Congratulations!"
                    } else {
                        this.hasResultView = "Ooops that's not correct! But keep trying!"
                    }
                    this.user.result = null
                    this.user.alias = null
                })
            },
            updateStats: function() {
                axios
                .get("http://localhost:8080/results?alias=" + this.user.alias)
                .then(response => {
                    this.gridData = response.data
                })
            }
        }
    })