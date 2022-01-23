# web-quiz-engine

### Project Description:
[Hyperskill - Web Quiz Engine](https://hyperskill.org/projects/91?track=1)

### Cloud Deployment:
https://web-quiz-engine.azurewebsites.net/

### Quiz:
<pre>
{  
  "title": "The Java Logo",  
  "text": "What is depicted on the Java logo?",  
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]  
  "answers" : 2  
}
</pre>


### Routes:
<pre>
GET /api/quizzes  
GET /api/quizzes/{id}  
GET /api/quizzes/completed  

POST /api/quizzes  
POST /api/quizzes/{id}/solve  

DELETE /api/quizzes/{id}
</pre>

### Need improvement:
