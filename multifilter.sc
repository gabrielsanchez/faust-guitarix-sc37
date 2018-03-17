FaustMultifilter : UGen
{
  *ar { | in1, q125(50.0), q16k(50.0), q1k(50.0), q250(50.0), q2k(50.0), q31_25(50.0), q4k(50.0), q500(50.0), q62_5(50.0), q8k(50.0), f125(0.0), f16k(0.0), f1k(0.0), f250(0.0), f2k(0.0), f31_25(0.0), f4k(0.0), f500(0.0), f62_5(0.0), f8k(0.0) |
      ^this.multiNew('audio', in1, q125, q16k, q1k, q250, q2k, q31_25, q4k, q500, q62_5, q8k, f125, f16k, f1k, f250, f2k, f31_25, f4k, f500, f62_5, f8k)
  }

  *kr { | in1, q125(50.0), q16k(50.0), q1k(50.0), q250(50.0), q2k(50.0), q31_25(50.0), q4k(50.0), q500(50.0), q62_5(50.0), q8k(50.0), f125(0.0), f16k(0.0), f1k(0.0), f250(0.0), f2k(0.0), f31_25(0.0), f4k(0.0), f500(0.0), f62_5(0.0), f8k(0.0) |
      ^this.multiNew('control', in1, q125, q16k, q1k, q250, q2k, q31_25, q4k, q500, q62_5, q8k, f125, f16k, f1k, f250, f2k, f31_25, f4k, f500, f62_5, f8k)
  } 

  checkInputs {
    if (rate == 'audio', {
      1.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"FaustMultifilter" }


  info { ^"Generated with Faust" }
}

