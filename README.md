# web-quiz-engine

### Project Description:
[Hyperskill - Web Quiz Engine](https://hyperskill.org/projects/91?track=1)

### Cloud Deployment:
https://web-quiz-engine.azurewebsites.net/

### User:
<pre>
{
  "email": "test@gmail.com",
  "password": "secret"
}
</pre>

### Quiz:
<pre>
{  
  "title": "The Java Logo",  
  "text": "What is depicted on the Java logo?",  
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]  
  "answers" : [2]
}
</pre>

### Routes:
<pre>
GET /api/quizzes  
GET /api/quizzes/{id}  
GET /api/quizzes/completed  

POST /api/register
POST /api/quizzes  
POST /api/quizzes/{id}/solve  

DELETE /api/quizzes/{id}
</pre>


### Sample requests:
<pre>
curl -X POST https://web-quiz-engine.azurewebsites.net/api/register \
     -H 'Content-Type: application/json' \
     -d '{
          "email": "newuser@mail.com",
          "password": "12345"
        }'

curl -X POST https://web-quiz-engine.azurewebsites.net/api/quizzes \
     -H 'Content-Type: application/json' \
     -u 'newuser@mail.com:12345' \
     -d '{
           "title": "The Java Logo",
           "text": "What is depicted on the Java logo?",
           "options": ["Robot","Tea leaf","Cup of coffee","Bug"],
           "answers": [2]
         }'

curl -X GET https://web-quiz-engine.azurewebsites.net/api/quizzes \
     -u 'newuser@mail.com:12345'

curl -X GET https://web-quiz-engine.azurewebsites.net/api/quizzes/1 \
     -u 'newuser@mail.com:12345'

curl -X POST https://web-quiz-engine.azurewebsites.net/1/solve \
     -H 'Content-Type: application/json' \
     -u 'newuser@mail.com:12345' \
     -d '{
           "answer": [2]
         }'

curl -X GET https://web-quiz-engine.azurewebsites.net/api/quizzes/completed \
     -u 'newuser@mail.com:12345'

curl -X DELETE https://web-quiz-engine.azurewebsites.net/api/quizzes/1 \
     -u 'newuser@mail.com:12345'
</pre>

### Needs Improvement:
- Quiz's type check exception. Currently using `handleHttpMessageNotReadable`.
- Quiz's answer validation. Answer integer isn't in the range of answer's options.
