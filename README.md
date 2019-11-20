# Android Jetpack Project :  Masterclass in Java

## What is Android Jetpack?
Jetpack is a suite of libraries, tools, and guidance to help developers write high-quality apps easier.
Jetpack comprises the androidx package libraries, that provide backward compatibility, and that must be used after support version 28.00

## Libraries covered in this example
### Navigation
- Handles user journey through the app
- Removes complexity when moving from one screen to another
- Handles complex cases like:
  - Bottom tabbed navigation
  - App drawers
- Works with _generated classes_
#### Benefits
- Handles fragment transactions
- Handles back and up actions
- Manages de backstack
- Argument passing
- Transition animations
- Deep linking
#### Components
- Navigation Graph
- Nav host fragment
- Nav controller

  <p align=center>
    <img src="doc/navigation_graph.png" alt="Navigation Graph" width=70%>
  </p>
  <p align=right><small><i>navigation graph used in this excercise</i></small></p>
  
### LiveData
Is a component that is part of the Lifecycle framework that Android provides.

- **It is an OBSERVABLE:** _Object that emits some data_

- **Is Lifecycle aware:**  _It handles the lifecycle of the components attached to it. LiveData only emits data if the OBSERVER attached to it is in an **active state**_

- **No memory leaks**  _Because of the lifecycle awareness_

- **Always up to date data**  _If anything is attached to LiveData, will receive the latest information._

- **Manages configuration Changes**

### MVVM
Architectural Pattern (Model - View - ViewModel)

- **VIEW** 
_It is responsible of displaying information for the users. Ideally, only the view will be aware of the Android ecosystem_

- **MODEL** 
_It is the data_

- **VIEWMODEL** 
_It receives the data from the MODEL and prepares it in a way that the view can display it._
_There is a **component** called ViewModel_

### ViewModel

- Lifecycle aware component
- It has its own lifecycle
- It manages to attach itself to fragments

There are two components available for the ViewModel:

#### ViewModel

We will use this one if we want to separate completely it's functionality from everything related to Android ecosystem (context, fragment, activity, ...)

This way, our ViewModel will exist independently of our Android App.

#### AndroidViewModel

If our ViewModel depends somehow of our Android App, for instance if we want to save data in our device, we'll need a reference to a **Context**.

We usually do not want references to Activities or Fragments Context because they are very transients.

AndroidViewModel allows us to access the ApplicationContext, that has a lifecycle much wider.

- _Ideally every VIEW should have it's own ViewModel_
- _Is is important to instanciate the ViewModel using:

```
        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
```
_This way, every time we create the fragment (this), the ViewModel will handle it the updated data, and we will NOT instanciate a new ViewModel, sine it has an independent lifecycle_
