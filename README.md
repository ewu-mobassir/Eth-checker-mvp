# ETH-CHECKER-MVP
A basic prototype to check Ethereum wallet balance from public addresses. 

Built using Kotlin following the Model-View-Presenter architecture by Mobassir Ahsan

# Blog

# Adapting Applications for Foldable Phones and Why You Should Do It

The world of smartphones is a fast growing one, where innovation is present at every moment and the technology is moving forward at a rapid pace. And in this fast moving world of smartphones foldable phones might be the next big trend. 

As an app developer you might just ask yourself why should anyone deisgn or apdat already existing applications for foldable phones? Sticking to traditional development seems easier and the flexibiliy of foldable phones means much more complex UI designs required. Some might also think there's not a market for foldable phones yet. 

Well, the technology and market research proves both of these wrong. Recently market analysis shows the salses of foldable phones continues to surge. It is expected that 16 million foldable smartphones will ship in 2022, which would consilidate as one of the most prominent types of phones among the high end devices. [Source](https://www.displaysupplychain.com/press-release/foldable-smartphones-continued-to-surge-in-q122-strong-growth-expected-in-2022)

So, adapting your applications for foldable phones will ensure it stands out among these huge userbase. And in a highly competitive market like application development, standing out might be  just what you need to ensure your and your application's success.

And now onto the second point. Maybe you are convinced about the future of foldable smartphones. But all this folding, change of views and states might make you think designing for foldables is extremely hard. Well not really. If you have ever developed for both phones and tablets, then you are already more than ready for developing for foldable smartphones. After all, currently most foldable phone's lid open state is treated as a tablet and closed state is treated as a phone by the Android operating system. And it can be even better. Anyone can design foldable phones if they follow some simple steps. 

* **Never use fixed layouts** - First off is always using flexible layout. This should be common sense for every developer. As the last thing you would want is your application appearing too small on one screen and appearing out of screen on others. Make sure your activities are resizable by declaring `android:resizeableActivity
` in manifest.
* **Always keep the UI thread free** - Make sure the UI thread is always free so that the transition between folded and non-folded state is as smooth as possible. You don't want the user to be waiting for the elements to appear on screen.
* **Focus on Responsiveness** - Continuing on last point, focus on responsiveness of the application. Maybe add some animatons for the extra immersion.
* **Make use of the extra space** - Foldable phones is provides users with double the screen space. Take advantage of it, instead of just zooming in your view, add some extra elements to the screen and position them well.
* **Design smart, take advantage of the foldable states** - And the final step is to design smarter by making use of the foldable states. Currently there can be 3 states for phones which you can access directly from the Android operating system: Folded, half-open, full-open. Design while considering each of these states. These states can be easily checked using `FoldingFeature.State`

Following these recommendations any deveopers should be able to design apps for foldable phones. The market for it is just getting bigger and the opportunites are endless. Make the best use of it and design and adapt your apps for foldable smartphones. 
