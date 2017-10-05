package com.satish.training;

import java.util.Arrays;

import com.satish.collectors.CollectorReducers;
import com.satish.collectors.WordCounterStream;
import com.satish.lambda.BinaryOps;
import com.satish.lambda.ConstructorRef;
import com.satish.lambda.LambdaSyntax;
import com.satish.lambda.MethodReference;
import com.satish.lambda.closure.JavaClosure;
import com.satish.lambda.funsets.IntSet;
import com.satish.lambda.generator.GeneratorExamples;
import com.satish.lambda.probs.medaltally.MedalTally;
import com.satish.lambda.probs.wordcounter.FunctionWordCounter;
import com.satish.lambda.probs.wordcounter.WordCounterOld;
import com.satish.lambda.streams.StreamConstruction;
import com.satish.lambda.streams.transformation.FilterExample;
import com.satish.lambda.streams.transformation.FlatMapExample;
import com.satish.lambda.streams.transformation.GroupPartitionExamples;
import com.satish.lambda.streams.transformation.MapCollectors;
import com.satish.lambda.streams.transformation.MapExample;
import com.satish.lambda.streams.transformation.MyOption;
import com.satish.lambda.streams.transformation.OptionComposition;
import com.satish.lambda.streams.transformation.OptionUseCase;
import com.satish.lambda.streams.transformation.PrimitiveStreams;
import com.satish.lambda.streams.transformation.StatefulTransformations;
import com.satish.lambda.streams.transformation.StreamCollectors;
import com.satish.lambda.streams.transformation.StreamReduce;
import com.satish.lambda.streams.transformation.StreamReductions;

public class Contents {
	
	public static void main(String[] args) {
		Arrays.asList(
				/**
				 * Why Java 8?
				 * 
				 * https://spring.io/blog/2016/09/22/new-in-spring-5-functional-web-framework
				 */
				
				/**
				 * After completing this session we should be able to understand/write:
				 */
				
				//How Generators work.
				GeneratorExamples.class,
				
				//Medal tally example
				MedalTally.class,
				
				//Count number of words in a file: Our famous interview question.
				WordCounterOld.class,
				
				FunctionWordCounter.class,
				
				WordCounterStream.class,
				
				
				/**
				 * Lambda, method reference and high order functions.
				 */
				
				//Syntax and Lambda explained.
				LambdaSyntax.class,
				
				//Method reference
				MethodReference.class,
				
				//Constructor Reference Explained
				ConstructorRef.class,
				
				//More example of Method Reference
				BinaryOps.class,
				
				//Clousure or no closure in Java
				JavaClosure.class,
				
				
				/**
				 * Optional : what null should have been at the first place.
				 */
				
				OptionUseCase.class,
				OptionComposition.class,
				MyOption.class,
				
				
				/**
				 * Bit on functional programming. Filter, Map, reduce, flatMap
				 */
				
				
				/**
				 * Streams
				 */
				StreamConstruction.class,
				
				FilterExample.class,
				
				MapExample.class,
				
				FlatMapExample.class,
				
				PrimitiveStreams.class,
				
				
				
				/**
				 * Stream data manipulation operations.
				 * We would see how to transform data and then reduce.
				 */
				
				//Stateful Transformation
				StatefulTransformations.class,
				
				//Stream mutable reductions
				
				StreamReductions.class,
				
				StreamReduce.class,
				
				//Collectors: Special case of mutable reduction
				
				StreamCollectors.class,
				
				MapCollectors.class,
				
				GroupPartitionExamples.class,
				
				CollectorReducers.class,
				
				
				/**
				 * Optionals.
				 */
				
				IntSet.class,
				MyOption.class
				
				
				/**
				 * Parallel streams and how they work. Also understanding fork join.
				 */
				
				
				/**
				 * Designs and best practices.
				 * 
				 * 
				 */
	);
		
	}

}
