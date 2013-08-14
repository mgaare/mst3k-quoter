mst3k-quoter
============

A small project created for an Atl-Clj lightning talk, demonstrating
the wonders of [immutant](http://immutant.org/).

It comes from a simple problem: how can one get a random quote from
Mystery Science Theater 3000 on demand?

The solution was "live coded" in a short, 15-minute talk (with only
the most cursory glances at the pre-written code cheat sheets that
took an hour and half to prepare) at the Atl-Clj group, and is
presented here for the enlightenment of all.

This project demonstrates just two of the numerous wonderful features
of immutant: web handlers, and messaging. The front end application
"webber" creates an immutant web endpoint, and communicates with the
back end quotes data source "quoter" using immutant request/respond
synchronish messaging.

## How to Make It Go

* Install immutant by following the super easy [installation directions](http://immutant.org/install/)
* Deploy both of the apps, by running these commands from the project root:

```
lein immutant deploy ./webber
lein immutant deploy ./quoter
```

* Start immutant

```
lein immutant run
```

* Point your browser at http:/localhost:8080 and enjoy an unlimited
  supply of quotes from the greatest TV show of all time.

## What's Going On Here?

Quoter loads up the
[WikiQuote MST3K page](http://en.wikiquote.org/wiki/Mystery_Science_Theater_3000)
and then pulls out all the quotes using
[enlive](https://github.com/cgrand/enlive) - the quote page helpfully
puts all the quotes in `<dl>` tags making it easy for to get them with
an enlive selector. It picks one at random each time Webber asks for a
quote and sends it across immutant messaging.

## Acknowledgements

Thanks to the [Atl-Clj Group](http://www.meetup.com/Atl-Clj/),
[Jim Crossley](https://github.com/jcrossley3), and
[Chap Lovejoy](https://github.com/chaptastic)!
