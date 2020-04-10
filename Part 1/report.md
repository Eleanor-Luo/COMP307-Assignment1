# COMP 307 Assignment 1

## Part 1 Report



### Predicted class labels in the test set using basic KNN method where k=1

```yaml
Accuracy for K = 1 : 0.9438202247191011

Predicted Class: 3 Actual class: 3 
Predicted Class: 3 Actual class: 3 
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 3 Actual class: 2
Predicted Class: 3 Actual class: 3
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 3 Actual class: 3
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1 
Predicted Class: 3 Actual class: 3 
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 3 Actual class: 3
Predicted Class: 2 Actual class: 2
Predicted Class: 3 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 3 Actual class: 3
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1
Predicted Class: 3 Actual class: 3
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1 
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1
Predicted Class: 3 Actual class: 3
Predicted Class: 3 Actual class: 3 
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 1
Predicted Class: 3 Actual class: 3
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 3 Actual class: 3
Predicted Class: 2 Actual class: 2
Predicted Class: 3 Actual class: 3
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 2
Predicted Class: 3 Actual class: 3
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 2 Actual class: 2 
Predicted Class: 3 Actual class: 3
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1
Predicted Class: 1 Actual class: 1
Predicted Class: 2 Actual class: 2
Predicted Class: 1 Actual class: 1
```

### Classification accuracy for k=3 vs k=1

```yaml
Accuracy for K = 1 : 0.9438202247191011
Accuracy for K = 3 : 0.9550561797752809
```

As you can see there was a slight improvement in accuracy where k=3 this is because in some cases for k=1 the nearest neighbor for an instance is affected by noise, when k=3  the noise has a lower influence on the result.

### Advantages and Disadvantages of KNN

KNN is very easy to implement and use while at the same time achieving good results/accuracy. Though for larger data sets it is very computationally expensive testing each instance. It is also quite sensitive to noise/outliers in datasets. 

